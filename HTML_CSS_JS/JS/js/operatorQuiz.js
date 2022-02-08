// 변수 할당
let uniformPrice = 100000
let trainingSetPrice = 150000

// 덧셈
let totalPrice = uniformPrice + trainingSetPrice
console.log(`총 ${totalPrice}원에 물건을 구입합니다`)

// 20%할인
console.log(`총 ${totalPrice * 0.8}원에 물건을 구입합니다`)

// 20%할인
let discountPrice = totalPrice * 0.2
totalPrice -= discountPrice

// 출력
console.log(`총 ${totalPrice}원에 물건을 구입합니다`)