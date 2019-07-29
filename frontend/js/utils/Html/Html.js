export default function () {
    return new Html();
}

class Html {
    addAttribute(attributeToSet, attributeValue) {
        this.element.setAttribute(attributeToSet, attributeValue);

        return this;
    }
    addChild(elementToAdd) {
        if (elementToAdd.render() instanceof HTMLUnknownElement) {
            throw new Error("Invalid HTML tag");
        }
        this.element.append(elementToAdd.render());
        return this;
    }

    addClass(classToAdd) {
        if (this.element.classList.contains(classToAdd)) {
            throw new Error("duplicate class error");
        }
        this.element.classList.add(classToAdd);
        console.log(classToAdd);
        return this;
    }
    click(callback) {
        this.element.addEventListener("click", callback);
        return this;
    }
    create(elementType) {
        if (!elementType) {
            throw new Error("Must pass a Html element");
        }
        this.element = document.createElement(elementType);

        if (this.element instanceof HTMLUnknownElement) {
            throw new Error("invalid html element");
        }
        return this;
    }
    // kinda fuzzy on what all this is doing
    html(contentToAdd) {
        if (contentToAdd === undefined) {
            return this.element.innerHTML;
        }
        this.element.innerHtml = contentToAdd;

        return this;
    }

    _isClassQuery(query) {
        return query.startsWith(".");
    }
    _isIdQuery(query) {
        return query.startsWith("#");
    }
    // not fully understanding what this is doing
    render() {
        return this.element;
    }
    // this appears to just blank out the inner information, not sure how this is replacing 
    replace(element) {
        this.element.innerHTML = ''
        this.addChild(element)

        return this;
    }
    select(query) {
        const selection = document.querySelectorAll(query);

        if (selection.length === 1) {
            this.element = selection[0]
        }
        else {
            this.element = selection;
        }
        return this;
    }

    text(textToAdd) {
        if (textToAdd === undefined) {
            return this.element.textContent;
        }
        this.element.textContent = textToAdd;

        return this;
    }
}