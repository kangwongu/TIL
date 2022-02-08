// class Product {
//   constructor(name, price) {
//     this.name = name;
//     this.price = price;
//   }

//   printInfo() {
//     console.log(`이름: ${this.name}, 가격: ${this.price}`)
//   }
// }

// const notebook = new Product("MacBook", 2000000)

// notebook.printInfo()


// 객체 리터럴 사용
const computer = {
  name: "MacBook",
  price: 2000000,
  printInfo: function() {
    console.log(`이름: ${this.name}, 가격: ${this.price}`)
  }
}

computer.printInfo();