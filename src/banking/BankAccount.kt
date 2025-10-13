package banking

class BankAccount(
    val accountNumber: String,
    initialBalance: Double,
    ownerName: String
) {
    private var balance: Double = if (initialBalance >= 0) initialBalance else throw Exception("Отрицательный баланс")
    private var _ownerName: String = ownerName
    private var transactions: Int = 0

    constructor(accountNumber: String, ownerName: String) : this(accountNumber, 0.0, ownerName)

    fun getBalance(): Double = Math.round(balance * 100) / 100.0

    fun getOwnerName(): String = _ownerName

    fun setOwnerName(name: String) {
        if (name.length < 2) throw Exception("2 символа минимум")
        _ownerName = name
    }

    fun deposit(amount: Double) {
        if (amount <= 0) throw Exception("отрицательная сумма")
        balance += amount
        transactions++
    }

    fun withdraw(amount: Double): Boolean {
        if (amount <= 0) throw Exception("отрицательная сумма")
        if (amount <= balance) {
            balance -= amount
            transactions++
            return true
        }
        return false
    }

    fun getInfo(): String {
        return "$accountNumber $_ownerName ${getBalance()} $transactions"
    }
}