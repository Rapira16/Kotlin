package `6`
import banking.BankAccount

class Atm {
    private var currentAccount: BankAccount? = null

    fun insertCard(account: BankAccount) {
        currentAccount = account
        println("Принял")
    }

    fun ejectCard() {
        currentAccount = null
        println("Извлек")
    }

    fun checkBalance() {
        if (currentAccount == null) {
            println("Вставьте карту")
            return
        }
        println("Баланс: ${currentAccount!!.getBalance()}")
    }

    fun deposit(amount: Double) {
        if (currentAccount == null) {
            println("Вставьте карту")
            return
        }
        currentAccount!!.deposit(amount)
        println("Пополнено: $amount")
    }

    fun withdraw(amount: Double) {
        if (currentAccount == null) {
            println("Вставьте карту")
            return
        }
        if (currentAccount!!.withdraw(amount)) {
            println("Снято: $amount")
        } else {
            println("Недостаточно")
        }
    }

    fun showInfo() {
        if (currentAccount == null) {
            println("Вставьте карту")
            return
        }
        println(currentAccount!!.getInfo())
    }
}

fun main() {
    val account = BankAccount("123456", 1000.0, "Дима")
    val atm = Atm()
    account.setOwnerName("Дмитрий")

    atm.insertCard(account)
    atm.checkBalance()
    atm.deposit(500.0)
    atm.withdraw(200.0)
    atm.withdraw(2000.0)
    atm.showInfo()
    atm.ejectCard()
}