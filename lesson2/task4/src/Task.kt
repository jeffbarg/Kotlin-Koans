class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var date: MyDate = start.copy()

            override fun hasNext(): Boolean {
                return date <= end
            }

            override fun next(): MyDate {
                var nextDate = date.copy()
                date = date.nextDay()

                return nextDate
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
