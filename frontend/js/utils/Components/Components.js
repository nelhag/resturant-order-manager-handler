import Html from "../Html/Html";
import Api from "../Api/Api";

export default () => new Components()

class Components {
    getAppContext() {
        return Html().select("#app");

    }

    getWrapperDiv() {
        return Html()
            .create("div")
            .addClass("wrapper");
    }

    renderContentBlock() {
        const contentBlock = Html().create('section').addClass('content-block');
        const contentBlockTitle = Html().create('h3').addClass('content-block__title').text('We have Large Pizza');

        const greet = Html().create('h1').addClass('greeting').text('look around and place your order')
        const addvertSec = Html().create('section').addClass("addSection");
        const Img1 = Html().create("img").addClass('addvertisement');
        const Img2 = Html().create("img").addClass('addvertisement');
        const Img3 = Html().create("img").addClass('addvertisement');

        addvertSec.addChild(Img1);
        addvertSec.addChild(Img2);
        addvertSec.addChild(Img3);
        contentBlock.addChild(addvertSec);
        contentBlock.addChild(greet);
        contentBlock.addChild(contentBlockTitle);
        return contentBlock;
    }

    renderOrderSection() {
        const contentBlock = Html().create('section').addClass('content-block');
        const contentBlockTitle = Html().create('h3').addClass('content-block__title').text('We have Large Pizza');


        const formBlock = Html().create('form').addClass('Pizza-form').addAttribute("action", "").addAttribute("method", "POST")
        const labelName = Html().create('label')
        const labelNametext = Html().create('h3').text("Name")
        const InputName = Html().create('input').addAttribute("type", "text").addAttribute("name", "name").addAttribute("value", "ex: Your Name")
        const labelPay = Html().create('label')
        const labeyPayText = Html().create('h3').text('Payment')
        const labelPayCorC = Html().create("h4").text("Cash or Card")
        const inputPayT = Html().create('input').addAttribute("type", "radio").addAttribute("name", "payment method").addAttribute("value", "Cash")
        const inputPayF = Html().create('input').addAttribute("type", "radio").addAttribute("name", "payment method").addAttribute("value", "Card")


        const labelCrust = Html().create('label')
        const labelCrusttext = Html().create('h3').text('Crust')
        const crustButtonsSec = Html().create('div').addClass("crust")
        const crustButton1 = Html().create('input').addAttribute("type", "radio").addAttribute("name", "crust").addAttribute("value", "Thin")
        const crustButton2 = Html().create('input').addAttribute("type", "radio").addAttribute("name", "crust").addAttribute("value", "Thick")

        const labelSauce = Html().create('label')
        const labelSauceText = Html().create('h3').text('Sauce')
        const sauceButtonsSec = Html().create('div').addClass("sauce")
        const labelS1 = Html().create("label").text("Mild")
        const labelS2 = Html().create("label").text("Hot")
        const labelS3 = Html().create("label").text("Spicy Pepper")
        const labelS4 = Html().create("label").text("White")
        const sauceButton1 = Html().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "mild")
        const sauceButton2 = Html().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "Hot")
        const sauceButton3 = Html().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "Spicy Pepper")
        const sauceButton4 = Html().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "White")

        const toppingSec = Html().create('label')
        const toppingSecName = Html().create("h2").text('Toppings')

        const toppingDivCheese = Html().create('div').addClass('toppings-class')
        const chesseTitle = Html().create('h3').text('Cheese')
        const labelC1 = Html().create("label").text("Cheddar")
        const labelC2 = Html().create("label").text("Feta")
        const labelC3 = Html().create("label").text("non-lactose")
        const cheese1 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const cheese2 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const cheese3 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")

        const toppingDivProtein = Html().create('div').addClass('toppings-class')
        const meatTitle = Html().create('h3').text('Protein')
        const labelB1 = Html().create("label").text("Italian Sausage")
        const labelB2 = Html().create("label").text("Pepperoni")
        const labelB3 = Html().create("label").text("Ham")
        const labelB4 = Html().create("label").text("Bacon")
        const labelB5 = Html().create("label").text("Black Bean")
        const meat1 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", " ").addAttribute('value', "")
        const meat2 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const meat3 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const meat4 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const meat5 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")

        const toppingDivVeggie = Html().create('div').addClass('toppings-class')
        const VeggieTitle = Html().create('h3').text('Veggie')
        const labelV1 = Html().create("label").text("Mushrooms")
        const labelV2 = Html().create("label").text("Roasted Spinach")
        const labelV3 = Html().create("label").text("Red Onions")
        const labelV4 = Html().create("label").text("Mediterranean Black Olives")
        const labelV5 = Html().create("label").text("Pineapple")
        const labelV6 = Html().create("label").text("Green Bell Peppers")
        const Veggie1 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const Veggie2 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const Veggie3 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const Veggie4 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const Veggie5 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")
        const Veggie6 = Html().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "")

        const submitButtonDiv = Html().create('div').addClass('submit-buttons')
        const addAnotherPizzaButton = Html().create('button').addAttribute('type', "submit").text('Cofirm your order')
        const confirmORderButton = Html().create('button').addAttribute('type', "submit").text('Add another Pizza')

        submitButtonDiv.addChild(addAnotherPizzaButton)
        submitButtonDiv.addChild(confirmORderButton)
        toppingDivVeggie.addChild(VeggieTitle)
        labelV1.addChild(Veggie1)
        labelV2.addChild(Veggie2)
        labelV3.addChild(Veggie3)
        labelV4.addChild(Veggie4)
        labelV5.addChild(Veggie5)
        labelV6.addChild(Veggie6)
        toppingDivVeggie.addChild(labelV1)
        toppingDivVeggie.addChild(labelV2)
        toppingDivVeggie.addChild(labelV3)
        toppingDivVeggie.addChild(labelV4)
        toppingDivVeggie.addChild(labelV5)
        toppingDivVeggie.addChild(labelV6)
        labelB1.addChild(meat1)
        labelB2.addChild(meat2)
        labelB3.addChild(meat3)
        labelB4.addChild(meat4)
        labelB5.addChild(meat5)

        toppingDivProtein.addChild(meatTitle)
        toppingDivProtein.addChild(labelB1)
        toppingDivProtein.addChild(labelB2)
        toppingDivProtein.addChild(labelB3)
        toppingDivProtein.addChild(labelB4)
        toppingDivProtein.addChild(labelB5)
        labelC1.addChild(cheese1)
        labelC2.addChild(cheese2)
        labelC3.addChild(cheese3)
        toppingDivCheese.addChild(chesseTitle)
        toppingDivCheese.addChild(labelC1)
        toppingDivCheese.addChild(labelC2)
        toppingDivCheese.addChild(labelC3)
        toppingSec.addChild(toppingSecName)
        toppingSec.addChild(toppingDivCheese)
        toppingSec.addChild(toppingDivProtein)
        toppingSec.addChild(toppingDivVeggie)
        labelS1.addChild(sauceButton1)
        labelS2.addChild(sauceButton2)
        labelS3.addChild(sauceButton3)
        labelS4.addChild(sauceButton4)
        sauceButtonsSec.addChild(labelS1)
        sauceButtonsSec.addChild(labelS2)
        sauceButtonsSec.addChild(labelS3)
        sauceButtonsSec.addChild(labelS4)
        labelSauce.addChild(sauceButtonsSec)
        labelSauce.addChild(labelSauceText)
        crustButtonsSec.addChild(crustButton1)
        crustButtonsSec.addChild(crustButton2)
        labelCrust.addChild(labelCrusttext)
        labelCrust.addChild(crustButtonsSec)
        labelPay.addChild(labeyPayText)
        labelPay.addChild(labelPayCorC)
        labelPay.addChild(inputPayT)
        labelPay.addChild(inputPayF)
        labelName.addChild(labelNametext)
        labelName.addChild(InputName)
        formBlock.addChild(labelName)
        formBlock.addChild(labelPay)
        formBlock.addChild(labelCrust)
        formBlock.addChild(labelSauce)
        formBlock.addChild(toppingSec)
        formBlock.addChild(submitButtonDiv)
        contentBlock.addChild(contentBlockTitle)
        contentBlock.addChild(formBlock)

        return contentBlock

    }


    renderOrderList() {
        const contentBlock = Html().create('section').addClass('content-block');
        const contentBlockTitle = Html().create('h3').addClass('content-block__title').text('Order List');

        const contentBlockList = Html().create('ul').addClass('content-block__list');

        Api().getRequest('http://localhost:8080/api/orders', (Orders) => {
            Orders.forEach((order) => {
              
                const contentBlockListItem =
                Html()
                    .create('li')
                    .addClass('content-block__list-item')
                    .addChild(Html()
                        .create('a')
                        .addAttribute('href', `/orders/${order.id}`)
                        .text(order.name));
                contentBlockListItem.addChild(
                        Html().create('p').text(order.paymentMethod)
                )
                contentBlockListItem.addChild(
                    Html().create('p').text(order.orderTime)
            )
           
                    
                contentBlockList.addChild(contentBlockListItem);

            });
        });
        contentBlock.addChild(contentBlockTitle);
        contentBlock.addChild(contentBlockList);
        console.log("hello problem")
        return contentBlock;
    }
    renderPizzaList() {
        const contentBlock = Html().create('section').addClass('content-block');
        const contentBlockTitle = Html().create('h3').addClass('content-block__title').text('Pizza List');

        const contentBlockList = Html().create('ul').addClass('content-block__list');

        Api().getRequest('http://localhost:8080/api/pizzas', (Pizzas) => {
            Pizzas.forEach((pizza) => {
              
                const contentBlockListItem =
                Html()
                    .create('li')
                    .addClass('content-block__list-item')
                    .addChild(Html()
                        .create('a')
                        .addAttribute('href', `/pizzas/${pizza.id}`)
                        .text(pizza.itemName));
                
                contentBlockListItem.addChild(
                    Html().create('h3').text("comments"))
                    contentBlockListItem.addChild(
                    Html().create('p').text(pizza.comments)
            )
            contentBlockListItem.addChild(
                Html().create('p').text(pizza.crust)
        )
        contentBlockListItem.addChild(
            Html().create('p').text(pizza.sauce)
    )
    
                    
                contentBlockList.addChild(contentBlockListItem);

            });
        });
        contentBlock.addChild(contentBlockTitle);
        contentBlock.addChild(contentBlockList);
        console.log("hello problem")
        return contentBlock;
    }


    renderMainContent() {
        const mainContent = Html().create('main').addClass("main-content");
        const containerDiv = Html().create('div').addClass('container');
        // const contentBlock = this.renderContentBlock();
        // const contentBlock = this.renderOrderSection();
        // const contentBlock = this.renderOrderList();
        const contentBlock = this.renderPizzaList()
        containerDiv.addChild(contentBlock);
        mainContent.addChild(containerDiv);
        return mainContent;
    }

    renderMainFooter() {
        const mainFooter = Html().create('footer').addClass('main-footer');
        const mainFooterCopy = Html().create('small').addClass('main-footer__copty').html('&copy; 2019 Large Pizza\'s');
        mainFooter.addChild(mainFooterCopy);
        return mainFooter;

    }
    renderMainHeader() {
        const mainHeader = Html().create('header').addClass('main-header');
        const mainHeaderTitle = Html().create('h1').addClass('main-header__title').text('Welcome to Large Pizza');
        mainHeader.addChild(mainHeaderTitle);
        return mainHeader;
    }
    renderHomePage() {
        const app = this.getAppContext();
        const wrapperDiv = this.getWrapperDiv();
        const mainHeader = this.renderMainHeader();
        const mainContent = this.renderMainContent();
        const mainFooter = this.renderMainFooter();
        wrapperDiv.addChild(mainHeader);
        wrapperDiv.addChild(mainContent);
        wrapperDiv.addChild(mainFooter);
        app.addChild(wrapperDiv);
    }


}