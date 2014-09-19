package com.rhjensen.examples.spock

import spock.lang.Ignore
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

    /**
     *
     * Condition not satisfied:

     * a == b
     * | |  |
     * 6 |  7
     * false
     *
     */
    @Ignore
    def "A failure gives detailed information()"() {
        def a = 42 / 7
        def b = 35 / 5
        expect:
            a == b
    }

    def "It is easy to create 'parameterized' tests"() {
        expect:
            a == b
        where:
            a | b
            1 | 1
            true | true
            false | !true
            3 * 5 | 45 / 3
    }
}
