package samples.kotlin_fundamentals.section9_nullability


fun main(args: Array<String>) {
    var m: MeetingSection9? = null
    var newMeeting = MeetingSection9()


    // Can't do this because newMeeting isnt of type ?
    // newMeeting = m
    newMeeting = m ?: MeetingSection9()

    // Can't do this with regular method because closeMeeting() doesn't expect nullable
    //  closeMeeting(m)

    closeMeeting(m)
    closeMeeting(newMeeting)

    /**
     * let is only called if m is non-null,
     * Allows us to do null reference checks ourself with lamdbas
     */
    m?.let {
        closeMeetingNonNull(m)
    }
}

fun closeMeetingNonNull(m: MeetingSection9): Boolean? {
    return if (m.canClose) m.close()
    else false
}

fun closeMeeting(m: MeetingSection9?): Boolean? {
    return if (m?.canClose == true) m?.close()
    else false

    // This is not recommended
    // return if (m!!.canClose) m.close()
    // else false
}

class MeetingSection9 {
    val canClose: Boolean = false

    lateinit var address: AddressSection9

    fun close(): Boolean {
        return true
    }

    fun save(o: Any) {
        val saveable = o as? ISaveable
        saveable?.save()
    }

    fun init(addr: AddressSection9) {
        address = addr
    }
}

interface ISaveable {
    fun save()
}

class AddressSection9
