package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TransferTest {

    @Test
    fun maestroLessLimit() {
        val result = moneyTransfer("Maestro", 70000.00, 10000.00)

        assertEquals(0.0, result)
    }

    @Test
    fun masterCardLessLimit() {
        val result = moneyTransfer("Mastercard", 70000.00, 10000.00)

        assertEquals(0.0, result)
    }

    @Test
    fun maestroOvertLimit() {
        val result = moneyTransfer("Maestro", 100000.00, 140000.00)

        assertEquals(930.0, result)
    }

    @Test
    fun masterCardOvertLimit() {
        val result = moneyTransfer("Mastercard", 100000.00, 140000.00)

        assertEquals(930.0, result)
    }

    @Test
    fun visaLess35() {
        val result = moneyTransfer("Visa", 0.00, 100.00)

        assertEquals(35.0, result)
    }

    @Test
    fun mirLess35() {
        val result = moneyTransfer("Мир", 0.00, 100.00)

        assertEquals(35.0, result)
    }

    @Test
    fun visaOver35() {
        val result = moneyTransfer("Visa", 0.00, 10000.00)

        assertEquals(75.0, result)
    }

    @Test
    fun mirOver35() {
        val result = moneyTransfer("Мир", 0.00, 10000.00)

        assertEquals(75.0, result)
    }

    @Test
    fun vk() {
        val result = moneyTransfer("VkPay", 1000.00, 10000.00)

        assertEquals(0.0, result)
    }

    @Test
    fun maxLimitVK() {
        val result = moneyTransfer("VkPay", 60000.00, 10000.00)

        assertEquals("Превышен лимит", result)
    }

    @Test
    fun maxLimitVkAmount() {
        val result = moneyTransfer("VkPay", 10000.00, 60000.00)

        assertEquals("Превышен лимит", result)
    }

    @Test
    fun maxLimit() {
        val result = moneyTransfer("Visa", 6000000.00, 10000.00)

        assertEquals("Превышен лимит", result)
    }

    @Test
    fun maxLimitAmount() {
        val result = moneyTransfer("Visa", 0.00, 100000000.00)

        assertEquals("Превышен лимит", result)
    }
}