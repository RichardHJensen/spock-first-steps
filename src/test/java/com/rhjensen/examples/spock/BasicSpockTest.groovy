package com.rhjensen.examples.spock

import spock.lang.Specification

/**
 * User: rjensen
 * Date: 9/19/14
 * Time: 5:51 AM
 */
class BasicSpockTest extends Specification {
    def "It should just work"() {
        expect:
            true == true
    }
}
