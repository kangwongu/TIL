function calculateAvg(price1, price2) {
  const sum = price1 + price2
  console.log(`두 상품의 가격 총합은 ${sum}입니다.`)
  const avg = sum/2
  return avg
}

const priceA = 1000
const priceB = 2000
const avg1 = calculateAvg(priceA, priceB)
console.log(avg1)

const priceC = 4000
const priceD = 9000
const avg2 = calculateAvg(priceC, priceD)
console.log(avg2)