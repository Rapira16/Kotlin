// ненужное поле
abstract class BankCard(val cardNumber: String, var pinCode: Int) {
    abstract fun getBalance(): Double
    abstract fun updateBalance(amount: Double)
}


class CreditCard(cardNumber: String, pinCode: Int, val creditLimit: Double) : BankCard(cardNumber, pinCode) {
    private var debt: Double = 0.0

    override fun getBalance(): Double {
        return creditLimit - debt // исправил логику для кредитки
    }

    override fun updateBalance(amount: Double) {
        debt -= amount // здесь тоже исправил
    }

    // ненужная функция
    fun getAvailableCredit(): Double { // убрал oprn. Излишняя вещь
        return creditLimit - debt
    }
}


class DebitCard(cardNumber: String, pinCode: Int) : BankCard(cardNumber, pinCode) {
    private var balance: Double = 0.0

    override fun getBalance(): Double {
        return balance
    }

    override fun updateBalance(amount: Double) {
        balance += amount // нужно добавлять
    }

    // ненужный класс
    data class AdditionalInfo(val ownerName: String)
}


enum class TransactionType {
    WITHDRAWAL,
    DEPOSIT;
    // ненужная функция
    fun fromString(type: String): TransactionType {
        return valueOf(type.uppercase())
    }
}


data class Transaction(
    val cardNumber: String,
    val amount: Double,
    val date: String,
    val type: TransactionType
) {
    // ненужное поле
    var transactionId: String = ""
        get() = field // ненужный геттер
        set(value) { field = value } // ненужный сеттер
}


class ATM {

    private var transactions: MutableList<Transaction> = mutableListOf() // инициализация

    //конструктор здесь не нужен

    fun makeTransaction(card: BankCard, amount: Double, date: String, type: TransactionType): Boolean {

        when (type) {
            TransactionType.WITHDRAWAL -> {
                if (card.getBalance() >= amount) {
                    card.updateBalance(-amount)
                    transactions.add(Transaction(card.cardNumber, amount, date, type))
                    return true
                }
            }
            TransactionType.DEPOSIT -> {
                card.updateBalance(amount)
                transactions.add(Transaction(card.cardNumber, amount, date, type))
                return true
            }

        }
        return false
    }

    fun printTransactions(cardNumber: String) {

        val cardTransactions = transactions.filter { it.cardNumber == cardNumber }
        println("Транзакции по карте $cardNumber:")
        for (transaction in cardTransactions) {

            println("${transaction.date}: ${transaction.type} ${transaction.amount}")
        }
    }

    // не нужная функция
    fun getAllTransactions(): MutableList<Transaction> {
        return transactions
    }
}


fun main() {
    val atm = ATM()

    val creditCard = CreditCard("1234-5678-9012-3456", 1234, 10000.0)
    val debitCard = DebitCard("9876-5432-1098-7654", 5678)

    debitCard.updateBalance(5000.0)

    atm.makeTransaction(creditCard, 2000.0, "2025-01-15", TransactionType.WITHDRAWAL)
    atm.makeTransaction(debitCard, 1000.0, "2025-01-15", TransactionType.DEPOSIT) // была просто строка
    atm.makeTransaction(debitCard, 2000.0, "2025-01-15", TransactionType.WITHDRAWAL)
    atm.makeTransaction(creditCard, 3000.0, "2025-01-16", TransactionType.DEPOSIT)

    println("Баланс кредитной карты: ${creditCard.getBalance()}")
    println("Баланс дебетовой карты: ${debitCard.getBalance()}")

    atm.printTransactions("1234-5678-9012-3456")
}