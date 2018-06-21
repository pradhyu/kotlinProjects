import com.oauth1.SpecialSymbol


fun main(args: Array<String>) {
println(sortColors(intArrayOf(2,0,2,1,1,0)).contentToString())
    println("title,description".replace(SpecialSymbol.COMMA.plain,SpecialSymbol.COMMA.encoded))
}

fun sortColors(nums: IntArray):IntArray {
    var zero = -1
    var one = 0
    var two = nums.size
    while (one < two) {
        if (nums[one] == 0) {
            swap(nums, ++zero, one++)
        } else if (nums[one] == 2) {
            swap(nums, --two, one)
        } else {
            ++one
        }
    }
   return nums
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
}


