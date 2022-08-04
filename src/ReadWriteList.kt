@Suppress("UNCHECKED_CAST")
class ReadWriteList<T> {

    var list1 = arrayOfNulls<Any?>(100)
    var list2 = arrayOfNulls<Any?>(100)
    var count = 0

    fun get(index: Int): T {
        count = index
        return if (list1!=null){ list1.get(index)} else {list2.get(index)} as T
    }

    fun findFirst(p: (String) -> T):T{
        return if (list1!=null){ list1.firstOrNull()} else {list2.firstOrNull()} as T
    }

    fun findAll(p: (T) -> T): String {
        for (i in list1.size until list2.size){
            if (list1[i]!=null){
                println(list1[i])
            }else if (list2!=null){
                println(list2[i])
            }
        }
        return ""
    }

    fun add(item:T){
        if (count==0){
            list1[count++]=item
        }else{
            list2= arrayOfNulls(list1.size+1)
            for (i in list1.indices){
                list2[i]=list1[i]
            }
            list2[list1.lastIndex]=item
            list1= emptyArray()
            list1=list2
            list2= emptyArray()
        }

        fun add(index: Int,item: T){
            list1= arrayOfNulls(list1.size+1)
            for (i in list1.indices){
                if (i == index){
                    list2[i]=item
                }else{
                    list2[i]=list1[i]
                }
            }
            list2[list2.lastIndex]=list1[index]
            list1= emptyArray()
            list1= arrayOfNulls(list2.size)
            list1=list2
            list2= emptyArray()
        }
    }

    fun addAll(vararg item: T){
        list2= arrayOfNulls(list1.size+item.size)
        for (i in list1.indices){
            list2[i]=list1[i]
        }
        var temp=0
        for (i in list1.size until list2.size){
            list2[i]=item[temp++]
        }
        list1= emptyArray()
        list1=list2
        list2= emptyArray()
    }


}