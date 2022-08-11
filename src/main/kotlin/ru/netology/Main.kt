package ru.netology

fun main() {

    println(moneyTransfer("Maestro", 100000.00, 10000.00))
    println(moneyTransfer("Visa", 100000.00, 10000.00))
    println(moneyTransfer("VkPay", 50000.00, 10000.00))

}

fun moneyTransfer(typeCard: String = "VkPay", amountLast: Double = 0.00, amount: Double): Comparable<*> {

    val commissionVisaMir = amount / 100 * 0.75
    val maxLimit = amountLast >= 600000.00 || amount >= 150000.00
    val maxLimitVK = (typeCard == "VkPay") && (amount >= 15000.00 || amountLast >= 40000.00)

    var commission = when (typeCard) {
        "Mastercard", "Maestro" -> if (amountLast < 75000.00) 0.00 else (((amount / 100 * 0.65) + 20.00))
        "Visa", "Мир" -> if (commissionVisaMir < 35.00) 35.00 else commissionVisaMir
        else -> 0.00
    }
    val finalCommission = when {
        maxLimitVK -> "Превышен лимит"
        maxLimit -> "Превышен лимит"
        else -> commission
    }
    return finalCommission
}