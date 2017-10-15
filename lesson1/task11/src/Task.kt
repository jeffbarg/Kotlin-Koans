import java.util.*

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object: java.util.Comparator<Int> {
        override fun compare(first: Int, second: Int): Int {
            return second - first
        }
    })
    return arrayList
}
