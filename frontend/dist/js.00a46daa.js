// modules are defined as an array
// [ module function, map of requires ]
//
// map of requires is short require name -> numeric require
//
// anything defined in a previous bundle is accessed via the
// orig method which is the require for previous bundles
parcelRequire = (function (modules, cache, entry, globalName) {
  // Save the require from previous bundle to this closure if any
  var previousRequire = typeof parcelRequire === 'function' && parcelRequire;
  var nodeRequire = typeof require === 'function' && require;

  function newRequire(name, jumped) {
    if (!cache[name]) {
      if (!modules[name]) {
        // if we cannot find the module within our internal map or
        // cache jump to the current global require ie. the last bundle
        // that was added to the page.
        var currentRequire = typeof parcelRequire === 'function' && parcelRequire;
        if (!jumped && currentRequire) {
          return currentRequire(name, true);
        }

        // If there are other bundles on this page the require from the
        // previous one is saved to 'previousRequire'. Repeat this as
        // many times as there are bundles until the module is found or
        // we exhaust the require chain.
        if (previousRequire) {
          return previousRequire(name, true);
        }

        // Try the node require function if it exists.
        if (nodeRequire && typeof name === 'string') {
          return nodeRequire(name);
        }

        var err = new Error('Cannot find module \'' + name + '\'');
        err.code = 'MODULE_NOT_FOUND';
        throw err;
      }

      localRequire.resolve = resolve;
      localRequire.cache = {};

      var module = cache[name] = new newRequire.Module(name);

      modules[name][0].call(module.exports, localRequire, module, module.exports, this);
    }

    return cache[name].exports;

    function localRequire(x){
      return newRequire(localRequire.resolve(x));
    }

    function resolve(x){
      return modules[name][1][x] || x;
    }
  }

  function Module(moduleName) {
    this.id = moduleName;
    this.bundle = newRequire;
    this.exports = {};
  }

  newRequire.isParcelRequire = true;
  newRequire.Module = Module;
  newRequire.modules = modules;
  newRequire.cache = cache;
  newRequire.parent = previousRequire;
  newRequire.register = function (id, exports) {
    modules[id] = [function (require, module) {
      module.exports = exports;
    }, {}];
  };

  var error;
  for (var i = 0; i < entry.length; i++) {
    try {
      newRequire(entry[i]);
    } catch (e) {
      // Save first error but execute all entries
      if (!error) {
        error = e;
      }
    }
  }

  if (entry.length) {
    // Expose entry point to Node, AMD or browser globals
    // Based on https://github.com/ForbesLindesay/umd/blob/master/template.js
    var mainExports = newRequire(entry[entry.length - 1]);

    // CommonJS
    if (typeof exports === "object" && typeof module !== "undefined") {
      module.exports = mainExports;

    // RequireJS
    } else if (typeof define === "function" && define.amd) {
     define(function () {
       return mainExports;
     });

    // <script>
    } else if (globalName) {
      this[globalName] = mainExports;
    }
  }

  // Override the current require with this new one
  parcelRequire = newRequire;

  if (error) {
    // throw error from earlier, _after updating parcelRequire_
    throw error;
  }

  return newRequire;
})({"js/utils/Html/Html.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

function _default() {
  return new Html();
}

var Html =
/*#__PURE__*/
function () {
  function Html() {
    _classCallCheck(this, Html);
  }

  _createClass(Html, [{
    key: "addAttribute",
    value: function addAttribute(attributeToSet, attributeValue) {
      this.element.setAttribute(attributeToSet, attributeValue);
      return this;
    }
  }, {
    key: "addChild",
    value: function addChild(elementToAdd) {
      if (elementToAdd.render() instanceof HTMLUnknownElement) {
        throw new Error("Invalid HTML tag");
      }

      this.element.append(elementToAdd.render());
      return this;
    }
  }, {
    key: "addClass",
    value: function addClass(classToAdd) {
      if (this.element.classList.contains(classToAdd)) {
        throw new Error("duplicate class error");
      }

      this.element.classList.add(classToAdd);
      console.log(classToAdd);
      return this;
    }
  }, {
    key: "click",
    value: function click(callback) {
      this.element.addEventListener("click", callback);
      return this;
    }
  }, {
    key: "create",
    value: function create(elementType) {
      if (!elementType) {
        throw new Error("Must pass a Html element");
      }

      this.element = document.createElement(elementType);

      if (this.element instanceof HTMLUnknownElement) {
        throw new Error("invalid html element");
      }

      return this;
    } // kinda fuzzy on what all this is doing

  }, {
    key: "html",
    value: function html(contentToAdd) {
      if (contentToAdd === undefined) {
        return this.element.innerHTML;
      }

      this.element.innerHtml = contentToAdd;
      return this;
    }
  }, {
    key: "_isClassQuery",
    value: function _isClassQuery(query) {
      return query.startsWith(".");
    }
  }, {
    key: "_isIdQuery",
    value: function _isIdQuery(query) {
      return query.startsWith("#");
    } // not fully understanding what this is doing

  }, {
    key: "render",
    value: function render() {
      return this.element;
    } // this appears to just blank out the inner information, not sure how this is replacing 

  }, {
    key: "replace",
    value: function replace(element) {
      this.element.innerHTML = '';
      this.addChild(element);
      return this;
    }
  }, {
    key: "select",
    value: function select(query) {
      var selection = document.querySelectorAll(query);

      if (selection.length === 1) {
        this.element = selection[0];
      } else {
        this.element = selection;
      }

      return this;
    }
  }, {
    key: "text",
    value: function text(textToAdd) {
      if (textToAdd === undefined) {
        return this.element.textContent;
      }

      this.element.textContent = textToAdd;
      return this;
    }
  }]);

  return Html;
}();
},{}],"js/utils/Api/Api.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = _default;

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

function _default() {
  return new Api();
}

var Api =
/*#__PURE__*/
function () {
  function Api() {
    _classCallCheck(this, Api);
  }

  _createClass(Api, [{
    key: "getRequest",
    value: function getRequest(location, callback) {
      fetch(location).then(function (response) {
        return response.json();
      }).then(callback).catch(function (err) {
        return console.log(err);
      });
    }
  }, {
    key: "postRequest",
    value: function postRequest(location, requestBody, callback) {
      fetch(location, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(requestBody)
      }).then(function (response) {
        return response.json();
      }).then(callback).catch(function (err) {
        return console.log(err);
      });
    }
  }]);

  return Api;
}();
},{}],"js/utils/Components/Components.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = void 0;

var _Html = _interopRequireDefault(require("../Html/Html"));

var _Api = _interopRequireDefault(require("../Api/Api"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

var _default = function _default() {
  return new Components();
};

exports.default = _default;

var Components =
/*#__PURE__*/
function () {
  function Components() {
    _classCallCheck(this, Components);
  }

  _createClass(Components, [{
    key: "getAppContext",
    value: function getAppContext() {
      return (0, _Html.default)().select("#app");
    }
  }, {
    key: "getWrapperDiv",
    value: function getWrapperDiv() {
      return (0, _Html.default)().create("div").addClass("wrapper");
    }
  }, {
    key: "renderContentBlock",
    value: function renderContentBlock() {
      var contentBlock = (0, _Html.default)().create('section').addClass('content-block');
      var contentBlockTitle = (0, _Html.default)().create('h3').addClass('content-block__title').text('We have Large Pizza');
      var greet = (0, _Html.default)().create('h1').addClass('greeting').text('look around and place your order');
      var addvertSec = (0, _Html.default)().create('section').addClass("addSection");
      var Img1 = (0, _Html.default)().create("img").addClass('addvertisement');
      var Img2 = (0, _Html.default)().create("img").addClass('addvertisement');
      var Img3 = (0, _Html.default)().create("img").addClass('addvertisement');
      addvertSec.addChild(Img1);
      addvertSec.addChild(Img2);
      addvertSec.addChild(Img3);
      contentBlock.addChild(addvertSec);
      contentBlock.addChild(greet);
      contentBlock.addChild(contentBlockTitle);
      return contentBlock;
    }
  }, {
    key: "renderOrderSection",
    value: function renderOrderSection() {
      var contentBlock = (0, _Html.default)().create('section').addClass('content-block');
      var contentBlockTitle = (0, _Html.default)().create('h3').addClass('content-block__title').text('We have Large Pizza');
      var formBlock = (0, _Html.default)().create('form').addClass('Pizza-form').addAttribute("action", "").addAttribute("method", "POST");
      var labelName = (0, _Html.default)().create('label');
      var labelNametext = (0, _Html.default)().create('h3').text("Name");
      var InputName = (0, _Html.default)().create('input').addAttribute("type", "text").addAttribute("name", "name").addAttribute("value", "ex: Your Name");
      var labelPay = (0, _Html.default)().create('label');
      var labeyPayText = (0, _Html.default)().create('h3').text('Payment');
      var labelPayCorC = (0, _Html.default)().create("h4").text("Cash or Card");
      var inputPayT = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "payment method").addAttribute("value", "Cash");
      var inputPayF = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "payment method").addAttribute("value", "Card");
      var labelCrust = (0, _Html.default)().create('label');
      var labelCrusttext = (0, _Html.default)().create('h3').text('Crust');
      var crustButtonsSec = (0, _Html.default)().create('div').addClass("crust");
      var crustButton1 = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "crust").addAttribute("value", "Thin");
      var crustButton2 = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "crust").addAttribute("value", "Thick");
      var labelSauce = (0, _Html.default)().create('label');
      var labelSauceText = (0, _Html.default)().create('h3').text('Sauce');
      var sauceButtonsSec = (0, _Html.default)().create('div').addClass("sauce");
      var labelS1 = (0, _Html.default)().create("label").text("Mild");
      var labelS2 = (0, _Html.default)().create("label").text("Hot");
      var labelS3 = (0, _Html.default)().create("label").text("Spicy Pepper");
      var labelS4 = (0, _Html.default)().create("label").text("White");
      var sauceButton1 = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "mild");
      var sauceButton2 = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "Hot");
      var sauceButton3 = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "Spicy Pepper");
      var sauceButton4 = (0, _Html.default)().create('input').addAttribute("type", "radio").addAttribute("name", "sauce").addAttribute("value", "White");
      var toppingSec = (0, _Html.default)().create('label');
      var toppingSecName = (0, _Html.default)().create("h2").text('Toppings');
      var toppingDivCheese = (0, _Html.default)().create('div').addClass('toppings-class');
      var chesseTitle = (0, _Html.default)().create('h3').text('Cheese');
      var labelC1 = (0, _Html.default)().create("label").text("Cheddar");
      var labelC2 = (0, _Html.default)().create("label").text("Feta");
      var labelC3 = (0, _Html.default)().create("label").text("non-lactose");
      var cheese1 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var cheese2 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var cheese3 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var toppingDivProtein = (0, _Html.default)().create('div').addClass('toppings-class');
      var meatTitle = (0, _Html.default)().create('h3').text('Protein');
      var labelB1 = (0, _Html.default)().create("label").text("Italian Sausage");
      var labelB2 = (0, _Html.default)().create("label").text("Pepperoni");
      var labelB3 = (0, _Html.default)().create("label").text("Ham");
      var labelB4 = (0, _Html.default)().create("label").text("Bacon");
      var labelB5 = (0, _Html.default)().create("label").text("Black Bean");
      var meat1 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", " ").addAttribute('value', "");
      var meat2 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var meat3 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var meat4 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var meat5 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var toppingDivVeggie = (0, _Html.default)().create('div').addClass('toppings-class');
      var VeggieTitle = (0, _Html.default)().create('h3').text('Veggie');
      var labelV1 = (0, _Html.default)().create("label").text("Mushrooms");
      var labelV2 = (0, _Html.default)().create("label").text("Roasted Spinach");
      var labelV3 = (0, _Html.default)().create("label").text("Red Onions");
      var labelV4 = (0, _Html.default)().create("label").text("Mediterranean Black Olives");
      var labelV5 = (0, _Html.default)().create("label").text("Pineapple");
      var labelV6 = (0, _Html.default)().create("label").text("Green Bell Peppers");
      var Veggie1 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var Veggie2 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var Veggie3 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var Veggie4 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var Veggie5 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var Veggie6 = (0, _Html.default)().create('input').addAttribute('type', "checkbox").addAttribute("name", "").addAttribute('value', "");
      var submitButtonDiv = (0, _Html.default)().create('div').addClass('submit-buttons');
      var addAnotherPizzaButton = (0, _Html.default)().create('button').addAttribute('type', "submit").text('Cofirm your order');
      var confirmORderButton = (0, _Html.default)().create('button').addAttribute('type', "submit").text('Add another Pizza');
      submitButtonDiv.addChild(addAnotherPizzaButton);
      submitButtonDiv.addChild(confirmORderButton);
      toppingDivVeggie.addChild(VeggieTitle);
      labelV1.addChild(Veggie1);
      labelV2.addChild(Veggie2);
      labelV3.addChild(Veggie3);
      labelV4.addChild(Veggie4);
      labelV5.addChild(Veggie5);
      labelV6.addChild(Veggie6);
      toppingDivVeggie.addChild(labelV1);
      toppingDivVeggie.addChild(labelV2);
      toppingDivVeggie.addChild(labelV3);
      toppingDivVeggie.addChild(labelV4);
      toppingDivVeggie.addChild(labelV5);
      toppingDivVeggie.addChild(labelV6);
      labelB1.addChild(meat1);
      labelB2.addChild(meat2);
      labelB3.addChild(meat3);
      labelB4.addChild(meat4);
      labelB5.addChild(meat5);
      toppingDivProtein.addChild(meatTitle);
      toppingDivProtein.addChild(labelB1);
      toppingDivProtein.addChild(labelB2);
      toppingDivProtein.addChild(labelB3);
      toppingDivProtein.addChild(labelB4);
      toppingDivProtein.addChild(labelB5);
      labelC1.addChild(cheese1);
      labelC2.addChild(cheese2);
      labelC3.addChild(cheese3);
      toppingDivCheese.addChild(chesseTitle);
      toppingDivCheese.addChild(labelC1);
      toppingDivCheese.addChild(labelC2);
      toppingDivCheese.addChild(labelC3);
      toppingSec.addChild(toppingSecName);
      toppingSec.addChild(toppingDivCheese);
      toppingSec.addChild(toppingDivProtein);
      toppingSec.addChild(toppingDivVeggie);
      labelS1.addChild(sauceButton1);
      labelS2.addChild(sauceButton2);
      labelS3.addChild(sauceButton3);
      labelS4.addChild(sauceButton4);
      sauceButtonsSec.addChild(labelS1);
      sauceButtonsSec.addChild(labelS2);
      sauceButtonsSec.addChild(labelS3);
      sauceButtonsSec.addChild(labelS4);
      labelSauce.addChild(sauceButtonsSec);
      labelSauce.addChild(labelSauceText);
      crustButtonsSec.addChild(crustButton1);
      crustButtonsSec.addChild(crustButton2);
      labelCrust.addChild(labelCrusttext);
      labelCrust.addChild(crustButtonsSec);
      labelPay.addChild(labeyPayText);
      labelPay.addChild(labelPayCorC);
      labelPay.addChild(inputPayT);
      labelPay.addChild(inputPayF);
      labelName.addChild(labelNametext);
      labelName.addChild(InputName);
      formBlock.addChild(labelName);
      formBlock.addChild(labelPay);
      formBlock.addChild(labelCrust);
      formBlock.addChild(labelSauce);
      formBlock.addChild(toppingSec);
      formBlock.addChild(submitButtonDiv);
      contentBlock.addChild(contentBlockTitle);
      contentBlock.addChild(formBlock);
      return contentBlock;
    }
  }, {
    key: "renderOrderList",
    value: function renderOrderList() {
      var contentBlock = (0, _Html.default)().create('section').addClass('content-block');
      var contentBlockTitle = (0, _Html.default)().create('h3').addClass('content-block__title').text('Order List');
      var contentBlockList = (0, _Html.default)().create('ul').addClass('content-block__list');
      (0, _Api.default)().getRequest('http://localhost:8080/api/pizzas', function (Pizzas) {
        Pizzas.forEach(function (pizza) {
          var pizzaOrderItem = pizza.id;
          var contentBlockListItem = (0, _Html.default)().create('p').text(pizzaOrderItem); // Html()
          //     .create('li')
          //     .addClass('content-block__list-item')
          //     .addChild(Html()
          //         .create('a')
          //         .addAttribute('href', `/orders/${pizzaOrder.id}`)
          //         .text(pizzaOrder.name));

          contentBlockList.addChild(contentBlockListItem);
        });
      });
      contentBlock.addChild(contentBlockTitle);
      contentBlock.addChild(contentBlockList);
      console.log("hello problem");
      return contentBlock;
    }
  }, {
    key: "renderMainContent",
    value: function renderMainContent() {
      var mainContent = (0, _Html.default)().create('main').addClass("main-content");
      var containerDiv = (0, _Html.default)().create('div').addClass('container'); // const contentBlock = this.renderContentBlock();
      // const contentBlock = this.renderOrderSection();

      var contentBlock = this.renderOrderList();
      containerDiv.addChild(contentBlock);
      mainContent.addChild(containerDiv);
      return mainContent;
    }
  }, {
    key: "renderMainFooter",
    value: function renderMainFooter() {
      var mainFooter = (0, _Html.default)().create('footer').addClass('main-footer');
      var mainFooterCopy = (0, _Html.default)().create('small').addClass('main-footer__copty').html('&copy; 2019 Large Pizza\'s');
      mainFooter.addChild(mainFooterCopy);
      return mainFooter;
    }
  }, {
    key: "renderMainHeader",
    value: function renderMainHeader() {
      var mainHeader = (0, _Html.default)().create('header').addClass('main-header');
      var mainHeaderTitle = (0, _Html.default)().create('h1').addClass('main-header__title').text('Welcome to Large Pizza');
      mainHeader.addChild(mainHeaderTitle);
      return mainHeader;
    }
  }, {
    key: "renderHomePage",
    value: function renderHomePage() {
      var app = this.getAppContext();
      var wrapperDiv = this.getWrapperDiv();
      var mainHeader = this.renderMainHeader();
      var mainContent = this.renderMainContent();
      var mainFooter = this.renderMainFooter();
      wrapperDiv.addChild(mainHeader);
      wrapperDiv.addChild(mainContent);
      wrapperDiv.addChild(mainFooter);
      app.addChild(wrapperDiv);
    }
  }]);

  return Components;
}();
},{"../Html/Html":"js/utils/Html/Html.js","../Api/Api":"js/utils/Api/Api.js"}],"js/main.js":[function(require,module,exports) {
"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.default = main;

var _Components = _interopRequireDefault(require("./utils/Components/Components"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function main() {
  (0, _Components.default)().renderHomePage();
}
},{"./utils/Components/Components":"js/utils/Components/Components.js"}],"js/index.js":[function(require,module,exports) {
"use strict";

var _main = _interopRequireDefault(require("./main"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

(0, _main.default)();
},{"./main":"js/main.js"}],"node_modules/parcel-bundler/src/builtins/hmr-runtime.js":[function(require,module,exports) {
var global = arguments[3];
var OVERLAY_ID = '__parcel__error__overlay__';
var OldModule = module.bundle.Module;

function Module(moduleName) {
  OldModule.call(this, moduleName);
  this.hot = {
    data: module.bundle.hotData,
    _acceptCallbacks: [],
    _disposeCallbacks: [],
    accept: function (fn) {
      this._acceptCallbacks.push(fn || function () {});
    },
    dispose: function (fn) {
      this._disposeCallbacks.push(fn);
    }
  };
  module.bundle.hotData = null;
}

module.bundle.Module = Module;
var checkedAssets, assetsToAccept;
var parent = module.bundle.parent;

if ((!parent || !parent.isParcelRequire) && typeof WebSocket !== 'undefined') {
  var hostname = "" || location.hostname;
  var protocol = location.protocol === 'https:' ? 'wss' : 'ws';
  var ws = new WebSocket(protocol + '://' + hostname + ':' + "50185" + '/');

  ws.onmessage = function (event) {
    checkedAssets = {};
    assetsToAccept = [];
    var data = JSON.parse(event.data);

    if (data.type === 'update') {
      var handled = false;
      data.assets.forEach(function (asset) {
        if (!asset.isNew) {
          var didAccept = hmrAcceptCheck(global.parcelRequire, asset.id);

          if (didAccept) {
            handled = true;
          }
        }
      }); // Enable HMR for CSS by default.

      handled = handled || data.assets.every(function (asset) {
        return asset.type === 'css' && asset.generated.js;
      });

      if (handled) {
        console.clear();
        data.assets.forEach(function (asset) {
          hmrApply(global.parcelRequire, asset);
        });
        assetsToAccept.forEach(function (v) {
          hmrAcceptRun(v[0], v[1]);
        });
      } else {
        window.location.reload();
      }
    }

    if (data.type === 'reload') {
      ws.close();

      ws.onclose = function () {
        location.reload();
      };
    }

    if (data.type === 'error-resolved') {
      console.log('[parcel] ✨ Error resolved');
      removeErrorOverlay();
    }

    if (data.type === 'error') {
      console.error('[parcel] 🚨  ' + data.error.message + '\n' + data.error.stack);
      removeErrorOverlay();
      var overlay = createErrorOverlay(data);
      document.body.appendChild(overlay);
    }
  };
}

function removeErrorOverlay() {
  var overlay = document.getElementById(OVERLAY_ID);

  if (overlay) {
    overlay.remove();
  }
}

function createErrorOverlay(data) {
  var overlay = document.createElement('div');
  overlay.id = OVERLAY_ID; // html encode message and stack trace

  var message = document.createElement('div');
  var stackTrace = document.createElement('pre');
  message.innerText = data.error.message;
  stackTrace.innerText = data.error.stack;
  overlay.innerHTML = '<div style="background: black; font-size: 16px; color: white; position: fixed; height: 100%; width: 100%; top: 0px; left: 0px; padding: 30px; opacity: 0.85; font-family: Menlo, Consolas, monospace; z-index: 9999;">' + '<span style="background: red; padding: 2px 4px; border-radius: 2px;">ERROR</span>' + '<span style="top: 2px; margin-left: 5px; position: relative;">🚨</span>' + '<div style="font-size: 18px; font-weight: bold; margin-top: 20px;">' + message.innerHTML + '</div>' + '<pre>' + stackTrace.innerHTML + '</pre>' + '</div>';
  return overlay;
}

function getParents(bundle, id) {
  var modules = bundle.modules;

  if (!modules) {
    return [];
  }

  var parents = [];
  var k, d, dep;

  for (k in modules) {
    for (d in modules[k][1]) {
      dep = modules[k][1][d];

      if (dep === id || Array.isArray(dep) && dep[dep.length - 1] === id) {
        parents.push(k);
      }
    }
  }

  if (bundle.parent) {
    parents = parents.concat(getParents(bundle.parent, id));
  }

  return parents;
}

function hmrApply(bundle, asset) {
  var modules = bundle.modules;

  if (!modules) {
    return;
  }

  if (modules[asset.id] || !bundle.parent) {
    var fn = new Function('require', 'module', 'exports', asset.generated.js);
    asset.isNew = !modules[asset.id];
    modules[asset.id] = [fn, asset.deps];
  } else if (bundle.parent) {
    hmrApply(bundle.parent, asset);
  }
}

function hmrAcceptCheck(bundle, id) {
  var modules = bundle.modules;

  if (!modules) {
    return;
  }

  if (!modules[id] && bundle.parent) {
    return hmrAcceptCheck(bundle.parent, id);
  }

  if (checkedAssets[id]) {
    return;
  }

  checkedAssets[id] = true;
  var cached = bundle.cache[id];
  assetsToAccept.push([bundle, id]);

  if (cached && cached.hot && cached.hot._acceptCallbacks.length) {
    return true;
  }

  return getParents(global.parcelRequire, id).some(function (id) {
    return hmrAcceptCheck(global.parcelRequire, id);
  });
}

function hmrAcceptRun(bundle, id) {
  var cached = bundle.cache[id];
  bundle.hotData = {};

  if (cached) {
    cached.hot.data = bundle.hotData;
  }

  if (cached && cached.hot && cached.hot._disposeCallbacks.length) {
    cached.hot._disposeCallbacks.forEach(function (cb) {
      cb(bundle.hotData);
    });
  }

  delete bundle.cache[id];
  bundle(id);
  cached = bundle.cache[id];

  if (cached && cached.hot && cached.hot._acceptCallbacks.length) {
    cached.hot._acceptCallbacks.forEach(function (cb) {
      cb();
    });

    return true;
  }
}
},{}]},{},["node_modules/parcel-bundler/src/builtins/hmr-runtime.js","js/index.js"], null)
//# sourceMappingURL=/js.00a46daa.js.map