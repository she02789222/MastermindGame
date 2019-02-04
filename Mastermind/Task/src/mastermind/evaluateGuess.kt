package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right = 0
    var wrong = 0
    val sList = mutableListOf<Int>()
    val gList = mutableListOf<Int>()
    val map = mutableMapOf('A' to 0, 'B' to 0, 'C' to 0, 'D' to 0, 'E' to 0, 'F' to 0)
    for (c in secret) {
        map[c] = map[c]!! + 1
    }
    for (sc in secret.withIndex()) {
        if (sList.contains(sc.index)) continue
        var flag = false
        val m = map
        for (gc in guess.withIndex()) {
            if (gList.contains(gc.index)) continue
            if(m[gc.value]!! <= 0) continue
            if(sc.value == gc.value) {
                if (sc.index == gc.index) {
                    m[sc.value] = m[sc.value]!! - 1
                    sList.add(sc.index)
                    gList.add(gc.index)
                    right++
                    break
                }
                else {
                    for (i in gc.index + 1 until 4) {
                        if(guess[i] == sc.value && i == sc.index) {
                            m[gc.value] = m[gc.value]!! - 1
                            sList.add(i)
                            gList.add(gc.index)
                            flag = true
                            right++
                            break
                        }
                    }
                    if(flag) {
                        break
                    }
                    else {
                        var flag2 = false
                        for (i in sc.index + 1 until 4) {
                            if(gc.index == i && gc.value == secret[i]) {
                                m[gc.value] = m[gc.value]!! - 1
//                                println("${gc.index} and ${gc.value}")
                                sList.add(i)
                                gList.add(gc.index)
                                flag2 = true
                                right++
                                break
                            }
                        }
                        if (flag2) continue
                        m[sc.value] = m[sc.value]!! - 1
                        gList.add(gc.index)
                        sList.add(sc.index)
//                        println("${sc.value}, ${gc.value}")
                        wrong++
                        break
                    }
                }
            }
        }
//        println("${sc.index}, right: $right, wrong: $wrong ")
//        m.forEach { t, u -> print(", <$t, $u>") }
//        println()
    }

    return Evaluation(right, wrong)
}
