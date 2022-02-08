let priceArr = [250000, 100000, 80000, 39000, 19000, 60000, 15000, 30000, 12000, 9900]
let sum = 0
let avg = 0

// for(let i=0; i<priceArr.length; i++) {
//   sum += priceArr[i]
// }

// console.log(sum)

for(let coast of priceArr) {
  sum += coast
}

avg = sum/priceArr.length

console.log(`총 금액은 ${sum}원 입니다.`)
console.log(`평균은 ${avg}원 입니다.`)
