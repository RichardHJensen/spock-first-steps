package com.rhjensen.examples.spock

import com.rhjensen.examples.ComputeValue
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
            a     | b
            1     | 1
            true  | true
            false | !true
            3 * 5 | 45 / 3
    }

    def "And it calls your Java class"() {
        def computer = new ComputeValue()

        expect:
            a == computer.computeValue(b)
        where:
            a     | b
            1     | 1
            true  | true
            false | !true
            45/3  | 5 * 3
    }

    /**
     *
     * computedValue ==  computer.computeValue(a) + computer.computeValue(b + computer.computeValue(c))
     * |             |   |        |            |  | |        |            | | |        |            |
     * 5             |   |        2            2  9 |        7            3 7 |        4            4
     *               |   |                          |                         com.rhjensen.examples.ComputeValue@35e28ef6
     *               |   |                          com.rhjensen.examples.ComputeValue@35e28ef6
     *               |   com.rhjensen.examples.ComputeValue@35e28ef6
     *               false
     *
     */
    def "Complex expressions show the value of the detailed message"() {
        def computer = new ComputeValue()

        expect:
            computedValue ==  computer.computeValue(a) + computer.computeValue(b + computer.computeValue(c))
        where:
            a | b | c | computedValue
            1 | 1 | 1 | 3
//            2 | 3 | 4 | 5
    }
}
