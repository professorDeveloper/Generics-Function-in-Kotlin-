class WriteOnlyList<T> {

    var list1 = arrayOfNulls<Any?>(100)
    var list2 = arrayOfNulls<Any?>(100)
    var count = 0

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