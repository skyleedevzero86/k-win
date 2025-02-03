package com.kwin.sos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KWinApplication

fun main(args: Array<String>) {
	runApplication<KWinApplication>(*args)
}
