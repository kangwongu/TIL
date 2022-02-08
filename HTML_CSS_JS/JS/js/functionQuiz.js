let shoes = 150000
let coat = 200000
let jean = 40000

function calculateAvg(item1, item2, item3) {
  let sum = item1 + item2 + item3
  console.log(`총 구매비용은 ${sum}원 입니다.`)

  let avg = sum/3
  return avg
}

let average = calculateAvg(shoes, coat, jean)
console.log(`평균은 ${average}입니다.`)