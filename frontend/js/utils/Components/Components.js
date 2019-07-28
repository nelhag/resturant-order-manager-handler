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
        const contentBlockTitle = Html().create('h3').addClass('content-block__title').text('Welcome_Large_Pizza');


        contentBlock.addChild(contentBlockTitle);
        return contentBlock;
    }

    renderMainContent() {
        const mainContent = Html().create('main').addClass("main-content");
        const containerDiv = Html().create('div').addClass('container');
        const contentBlock = this.renderContentBlock();
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
        const mainHeaderTitle = Html().create('h1').addClass('main-header__title').text('Large Pizza');
        mainHeader.addChild(mainHeaderTitle);
        return mainHeader;
    }
    renderPageHome() {
        const app = this.getAppContext();
        const wrapperDiv = this.getWrapperDiv();
        // const mainHeader = this.renderMainHeader();
        // const mainContent = this.renderMainContent();
        const mainFooter = this.renderMainFooter();
        // wrapperDiv.addChild(mainHeader);
        // wrapperDiv.addChild(mainContent);
        wrapperDiv.addChild(mainFooter);
        app.addChild(wrapperDiv);
    }


}