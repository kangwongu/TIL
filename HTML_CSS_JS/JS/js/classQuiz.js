class Cloths {
  constructor(color, size, price) {
    this.color = color
    this.size = size
    this.price = price
  }

  showInfo() {
    console.log(`색상: ${this.color}, 사이즈: ${this.size}, 가격: ${this.price}`)
  }
}

let blackCoat = new Cloths('Black', 'L', 250000)
blackCoat.showInfo()