# Generics-Function-in-Kotlin-



    fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var readWriteList1 = ReadWriteList<String>()
    var readOnlyList1 = ReadOnlyList<String>()

    readWriteList1.add("Hud")
    readWriteList1.add("Azamov")
    readWriteList1.add("STC")
    readWriteList1.add("Hasanxon")

    println(readWriteList1.get(1))
    println(readWriteList1.findFirst { "" })
    println(readWriteList1.findAll { "" })
}
