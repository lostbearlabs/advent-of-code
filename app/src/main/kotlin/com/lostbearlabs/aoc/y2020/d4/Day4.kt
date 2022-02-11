package com.lostbearlabs.aoc.y2020.d4

val requiredFields = listOf(
        "byr",
        "iyr",
        "eyr",
        "hgt",
        "hcl",
        "ecl",
        "pid",
//        "cid",
)

/*
byr (Birth Year) - four digits; at least 1920 and at most 2002.
iyr (Issue Year) - four digits; at least 2010 and at most 2020.
eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
hgt (Height) - a number followed by either cm or in:
If cm, the number must be at least 150 and at most 193.
If in, the number must be at least 59 and at most 76.
hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
pid (Passport ID) - a nine-digit number, including leading zeroes.
cid (Country ID) - ignored, missing or not.
 */

typealias Passport = Map<String,String>

fun Passport.hasRequiredFields() : Boolean {
    return requiredFields
            .map{this.containsKey(it)}
            .all { it }
}

fun isIntInRange(value: String, min: Int, max: Int) : Boolean {
    val n = value.toIntOrNull() ?: return false
    return n in min..max
}

fun isValidField(key: String, value: String) : Boolean {
    return when(key) {
        "byr" -> isIntInRange(value, 1920, 2002)
        "iyr" -> isIntInRange(value, 2010, 2020)
        "eyr" -> isIntInRange(value, 2020, 2030)
        "hgt" -> {
            when {
                value.endsWith("cm") -> isIntInRange( value.removeSuffix("cm"), 150, 193)
                value.endsWith("in") -> isIntInRange( value.removeSuffix("in"), 59, 76)
                else -> return false
            }
        }
        "hcl" -> value[0]=='#' && value.substring(1).all { it in '0'..'9' || it in 'a'..'f' }
        "ecl" -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(value)
        "pid" -> value.length==9 && value.toIntOrNull()!=null
        else -> true
    }
}

fun Passport.isValid(): Boolean {
    val fieldState = this.map{ isValidField(it.key, it.value)}
    return this.hasRequiredFields() && fieldState.all { it }
}

fun parsePassport(input: String) : Passport {
    val p = mutableMapOf<String,String>()
    input.split("\n", "\t", " ").forEach {
        val kv = it.split(":")
        p[kv[0]] = kv[1]
    }
    return p
}

fun parsePassportList(input: String) : List<Passport> {
    val chunks = input.split("\n\n".toRegex())
    return chunks.map{parsePassport(it)}
}
