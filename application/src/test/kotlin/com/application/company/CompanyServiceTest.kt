package com.application.company

import com.application.company.CompanyApplicationFixture.Companion.회사_수정_커맨드_생성
import com.application.company.port.`in`.command.CompanyCreateCommand
import com.application.company.port.out.CompanyRepositoryPort
import com.common.global.exceptions.CustomException
import com.core.domains.company.exception.CompanyExceptionType
import com.core.domains.company.vo.CompanyType
import company.CompanyFixture.Companion.회사_정상_생성
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.mockk.coEvery
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs

class CompanyServiceTest : BehaviorSpec({
    val companyRepositoryPort = mockk<CompanyRepositoryPort>()
    val companyService = CompanyService(companyRepositoryPort)

    Given("회사 생성 시") {
        val fixture = 회사_정상_생성()

        When("예외가 없다면") {
            coEvery { companyRepositoryPort.save(any()) } returns fixture

            Then("정상 생성된다") {
                val response = companyService.createCompany(
                    CompanyCreateCommand(
                        name = fixture.name,
                        description = fixture.description,
                        address = fixture.address,
                        url = fixture.url,
                        companyType = CompanyType.LARGE_COMPANY
                    )
                )
                response shouldBe fixture
            }
        }
    }

    Given("회사를 조회 시") {
        val fixture = 회사_정상_생성()

        When("값이 있다면") {
            coEvery { companyRepositoryPort.findById(fixture.id) } returns fixture
            val result = companyService.findCompanyById(fixture.id)

            Then("정상적으로 찾아온다") {
                result shouldBe fixture
            }
        }

        When("값이 없다면") {
            coEvery { companyRepositoryPort.findById(fixture.id) } returns null

            Then("예외를 발생시킨다") {
                val exception = shouldThrow<CustomException> {
                    companyService.findCompanyById(fixture.id)
                }
                exception.message shouldContain CompanyExceptionType.COMPANY_NOT_FOUND_EXCEPTION.message
            }
        }
    }

    Given("회사 정보 수정 시") {
        val fixture = 회사_정상_생성()
        val editFixture = 회사_수정_커맨드_생성(fixture.id)

        When("정보가 있다면") {
            coEvery { companyRepositoryPort.findById(editFixture.companyId) } returns fixture
            coEvery {
                companyRepositoryPort.editCompany(
                    eq(fixture.id),
                    any()
                )
            } returns 회사_정상_생성(name = editFixture.name)

            Then("정상 수정이 된다") {
                val result = companyService.editCompany(editFixture)
                result.name shouldBe editFixture.name
            }
        }

        When("정보가 없다면") {
            coEvery { companyRepositoryPort.findById(editFixture.companyId) } returns null

            Then("예외를 발생시킨다") {
                val exception = shouldThrow<CustomException> {
                    companyService.editCompany(editFixture)
                }
                exception.message shouldContain CompanyExceptionType.COMPANY_NOT_FOUND_EXCEPTION.message
            }
        }
    }

    Given("회사 삭제 시") {
        When("일반적으로 예외없이") {
            coEvery { companyRepositoryPort.deleteById(1L) } just runs

            Then("삭제한다") {
                shouldNotThrowAny { companyService.deleteCompanyById(1L) }
            }
        }
    }
})