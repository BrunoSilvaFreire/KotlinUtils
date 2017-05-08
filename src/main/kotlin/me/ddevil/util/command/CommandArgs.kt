package me.ddevil.util.command

import me.ddevil.util.checkArgument

fun commandArgsFrom(string: String): CommandArgs {
    val content = string.split(" ")
    val label = content.first()
    val args = content.slice(1..content.lastIndex).toTypedArray()
    return CommandArgs(label, args)
}

class CommandArgs {


    /**
     * Gets the label including sub command labels of this command

     * @return Something like 'test.subcommand'
     */
    val label: String

    /**
     * Gets all the arguments after the command's label. ie. if the command
     * label was test.subcommand and the arguments were subcommand foo foo, it
     * would only return 'foo foo' because 'subcommand' is part of the command

     * @return
     */
    val args: Array<String>


    constructor(label: String, args: Array<String>) {
        this.label = label
        this.args = args
    }

    /**
     * Returns the length of the command arguments

     * @return int length of args
     */
    val length get() = args.size


    /**
     * Gets the argument at the specified index

     * @param index The index to translate
     * *
     * @return The string at the specified index
     */
    operator fun get(index: Int) = args[index]

    operator fun contains(arg: String) = arg in args

    @JvmOverloads
    inline fun joinFromAnd(start: Int, end: Int = args.size - 1, action: (String) -> Unit) {
        var iStart = start
        checkArgument(length > start, "The start index ($start) is larger than the length (${length}")
        var message = String()
        val containsInitialQuote = get(start)[0] == '"'
        if (containsInitialQuote) {
            iStart++
        }
        if (length > iStart) {
            for (i in start..args.lastIndex) {
                if (i > end) {
                    break
                }
                val string = args[i]
                for (char in string) {
                    if (containsInitialQuote && char == '"') {
                        break
                    }
                    message += char
                }
                if (i != args.lastIndex) {
                    message += ' '
                }
            }
        }
        action(message)
    }

    inline fun getStringOrElse(index: Int, orElse: () -> Unit, action: (String) -> Unit) {
        if (length > index) {
            action(get(index))
        } else {
            orElse()
        }
    }

    inline fun getIntOrElse(index: Int,
                            orElse: () -> Unit,
                            invalidInt: (String) -> Unit,
                            action: (Int) -> Unit) {
        getStringOrElse(index, orElse) {
            try {
                action(it.toInt())
            } catch(e: NumberFormatException) {
                invalidInt(it)
            }
        }
    }


    inline fun getLongOrElse(index: Int,
                             orElse: () -> Unit,
                             invalidLong: (String) -> Unit,
                             action: (Long) -> Unit) {
        getStringOrElse(index, orElse) {
            try {
                action(it.toLong())
            } catch(e: NumberFormatException) {
                invalidLong(it)
            }
        }
    }

    inline fun getFloatOrElse(index: Int,
                              orElse: () -> Unit,
                              invalidFloat: (String) -> Unit,
                              action: (Float) -> Unit) {
        getStringOrElse(index, orElse) {
            try {
                action(it.toFloat())
            } catch(e: NumberFormatException) {
                invalidFloat(it)
            }
        }
    }

    inline fun getDoubleOrElse(index: Int,
                               orElse: () -> Unit,
                               invalidDouble: (String) -> Unit,
                               action: (Double) -> Unit) {
        getStringOrElse(index, orElse) {
            try {
                action(it.toDouble())
            } catch(e: NumberFormatException) {
                invalidDouble(it)
            }
        }
    }


}