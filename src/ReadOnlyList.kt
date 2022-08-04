class ReadOnlyList<T> {

    var list1 = arrayOfNulls<Any?>(100)
    var list2 = arrayOfNulls<Any?>(100)
    var count = 0

    fun get(index: Int): T {
        count = index
        return if (list1!=null){ list1.get(index)} else {list2.get(index)} as T
    }

    fun findFirst(p:(T)->Boolean ):T{
        return if (list1!=null){ list1.firstOrNull()} else {list2.firstOrNull()} as T
    }

    fun findAll(p: (String) -> String):Any?{
        for (i in list1.size until list2.size){
            if (list1[i]!=null){
                println(list1[i])
            }else if (list2!=null){
                println(list2[i])
            }
        }
        return ""
    }
}