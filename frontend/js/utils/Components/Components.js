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

    renderOrderSection(){
        const contentBlock = Html().create('section').addClass('content-block');
        const contentBlockTitle = Html().create('h3').addClass('content-block__title').text('We have Large Pizza');


        const formBlock = Html().create('form').addClass('Pizza-form').addAttribute("action","").addAttribute("method","POST")
        const labelName = Html().create('label')
        const labelNametext = Html().create('h2').text("Name")
        const InputName = Html().create('input').addAttribute("type","text").addAttribute("name","name").addAttribute("value","ex: Your Name")
        const labelPay = Html().create('label')
        const labeyPayText = Html().create('h2').text('payment')
        const inputPay = Html().create('input').addAttribute("type","boolean").addAttribute("name","payment method").addAttribute("value","Cash or Card")
        
        const labelCrust = Html().create('label')
        const labelCrusttext = Html().create('h2').text('Crust')
        const crustButtonsSec = Html().create('div').addClass("crust")
        const crustButton1 = Html().create('input').addAttribute("type","radio").addAttribute("name","crust").addAttribute("value","Thin")
        const crustButton2 = Html().create('input').addAttribute("type","radio").addAttribute("name","crust").addAttribute("value","Thick")
        
        const labelSauce = Html().create('label')
        const labelSauceText = Html().create('h2').text('Sauce') 
        const sauceButtonsSec = Html().create('div').addClass("sauce")
        const sauceButton1 = Html().create('input').addAttribute("type","radio").addAttribute("name","sauce").addAttribute("value","mild")
        const sauceButton2 = Html().create('input').addAttribute("type","radio").addAttribute("name","sauce").addAttribute("value","Hot")
        const sauceButton3 = Html().create('input').addAttribute("type","radio").addAttribute("name","sauce").addAttribute("value","Spicy Pepper")
        const sauceButton4 = Html().create('input').addAttribute("type","radio").addAttribute("name","sauce").addAttribute("value","White")

        const toppingSec = Html().create('label')
        const toppingSecName = Html().create("h2").text('Toppings')

        const toppingDivCheese = Html().create('div').addClass('toppings-class')
        const chesseTitle = Html().create('p').text('Cheese')
        const cheese1 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Cheddar")
        const cheese2 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Feta")
        const cheese3 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("non-lactose")

        const toppingDivProtein = Html().create('div').addClass('toppings-class')
        const meatTitle = Html().create('p').text('Protein')
        const meat1 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name"," ").addAttribute('value',"").text("Italian Sausage")
        const meat2 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Pepperoni")
        const meat3 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Ham")
        const meat4 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Bacon")
        const meat5 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Black Bean")
        
        const toppingDivVeggie = Html().create('div').addClass('toppings-class')
        const VeggieTitle = Html().create('p').text('Veggie')
        const Veggie1 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Mushrooms")
        const Veggie2 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Roasted Spinach")
        const Veggie3 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Red Onions")
        const Veggie4 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Mediterranean Black Olives")
        const Veggie5 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Green Bell Peppers")
        const Veggie6 = Html().create('input').addAttribute('type',"checkbox").addAttribute("name","").addAttribute('value',"").text("Pineapple")

        const submitButtonDiv = Html().create('div').addClass('submit-buttons')
        const addAnotherPizzaButton = Html().create('button').addAttribute('type',"submit").text('Cofirm your order')
        const confirmORderButton = Html().create('button').addAttribute('type',"submit").text('Add another Pizza')
    
        submitButtonDiv.addChild(addAnotherPizzaButton)
        submitButtonDiv.addChild(confirmORderButton)
        toppingDivVeggie.addChild(Veggie1)
        toppingDivVeggie.addChild(Veggie2)
        toppingDivVeggie.addChild(Veggie3)
        toppingDivVeggie.addChild(Veggie4)
        toppingDivVeggie.addChild(Veggie5)
        toppingDivVeggie.addChild(Veggie6)
        toppingDivVeggie.addChild(VeggieTitle)
        toppingDivProtein.addChild(meat1)
        toppingDivProtein.addChild(meat2)
        toppingDivProtein.addChild(meat3)
        toppingDivProtein.addChild(meat4)
        toppingDivProtein.addChild(meat5)
        toppingDivProtein.addChild(meatTitle)
        toppingDivCheese.addChild(cheese1)
        toppingDivCheese.addChild(cheese2)
        toppingDivCheese.addChild(cheese3)
        toppingDivCheese.addChild(chesseTitle)
        toppingSec.addChild(toppingDivCheese)
        toppingSec.addChild(toppingDivProtein)
        toppingSec.addChild(toppingDivVeggie)
        toppingSec.addChild(toppingSecName)
        sauceButtonsSec.addChild(sauceButton1)
        sauceButtonsSec.addChild(sauceButton2)
        sauceButtonsSec.addChild(sauceButton3)
        sauceButtonsSec.addChild(sauceButton4)
        labelSauce.addChild(sauceButtonsSec)
        labelSauce.addChild(labelSauceText)
        crustButtonsSec.addChild(crustButton1)
        crustButtonsSec.addChild(crustButton2)
        labelCrust.addChild(crustButtonsSec)
        labelCrust.addChild(labelCrusttext)
        labelPay.addChild(inputPay)
        labelPay.addChild(labeyPayText)
        labelName.addChild(InputName)
        labelName.addChild(labelNametext)
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


    renderMainContent() {
        const mainContent = Html().create('main').addClass("main-content");
        const containerDiv = Html().create('div').addClass('container');
        // const contentBlock = this.renderContentBlock();
        const contentBlock = this.renderOrderSection();
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