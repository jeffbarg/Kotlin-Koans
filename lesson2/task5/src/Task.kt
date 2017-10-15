import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

data class TimeDifference(val interval: TimeInterval, val multiplier: Int)

operator fun TimeInterval.times(multiplier: Int): TimeDifference {
    return TimeDifference(this, multiplier)
}

operator fun MyDate.plus(timeDifference: TimeDifference): MyDate {
    return this.addTimeIntervals(timeInterval = timeDifference.interval, number = timeDifference.multiplier)
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
