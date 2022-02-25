export class Item {
    private description: Array<string>;
    private price: number;

    constructor(description: Array<string>, price: number) {
        this.description = [...description];
        this.price = price;
    }

    getItem() {
        return {
            description: this.description.join(", "),
            price: this.price
        }
    }

    updateItem(description: Array<string>, price: number) {
        this.description = [...description];
        this.price = price;
    }
}

export class SubSection {
    private items: { [name: string]: Item };

    constructor(items: { [name: string]: Item }) {
        this.items = items;
    }

    getSubSection() {
        return {
            items: this.items
        };
    }

    getAllItems() {
        let newObj = {};
        for(const key of Object.keys(this.items)) {
            newObj[key] = this.items[key].getItem();
        }
        return newObj;
    }

    getItem(itemName: string) {
        return this.items[itemName] ? this.items[itemName].getItem() : "No item found";
    }

    updateSubSection(items: { [name: string]: Item }) {
        this.items = items;
    }

    addItem(itemName: string, description: Array<string>, price: number) {
        if (!this.items[itemName]){
            this.items[itemName] = new Item(description, price);
        } else {
            this.updateItem(itemName, description, price);
        }
    }

    updateItem(itemName: string, description: Array<string>, price: number) {
        this.items[itemName].updateItem(description, price);
    }

    removeItem(itemName: string) {
        if (this.items[itemName]) {
            delete this.items[itemName];
        }
    }
}

export class Section {
    private subSections: { [name: string]: SubSection };

    constructor(sections: { [name: string]: SubSection }) {
        this.subSections = sections;
    }

    getSection() {
        return {
            subSections: this.subSections
        };
    }

    getAllSubSections() {
        let newObj = {};
        for(const key of Object.keys(this.subSections)) {
            newObj[key] = this.subSections[key].getSubSection();
        }
        return newObj;
    }

    getAllSubSectionsAndItems() {
        let newObj = {};
        for(const key of Object.keys(this.subSections)) {
            newObj[key] = this.subSections[key].getAllItems();
        }
        return newObj;
    }

    getSubSection(subSectionName: string) {
        return this.subSections[subSectionName].getSubSection();
    }

    getAllItems(subSectionName: string) {
        return this.subSections[subSectionName].getAllItems();
    }

    getItem(subSectionName: string, itemName: string) {
        return this.subSections[subSectionName].getItem(itemName);
    }

    updateSection(subSections: { [name: string]: SubSection }) {
        for (const key in Object.keys(subSections)) {
            this.subSections[key] = subSections[key];
        }
    }

    addSubSection(subSectionName: string, items: { [name: string]: Item }){
        if (this.subSections[subSectionName]){
            return this.updateSubSection(subSectionName, items);
        }
        for (const key in Object.keys(items)) {
            this.subSections[subSectionName][key] = items[key];
        }
    }

    updateSubSection(subSectionName: string, items: { [name: string]: Item }){
        if (!this.subSections[subSectionName]){
            return this.addSubSection(subSectionName, items);
        }
        this.subSections[subSectionName].updateSubSection(items);
    }

    addItem(subSectionName: string, itemName: string, description: Array<string>, price: number) {
        if (this.subSections[subSectionName][itemName]) {
            return this.updateItem(subSectionName, itemName, description, price);
        }
        this.subSections[subSectionName].addItem(itemName, description, price);
    }

    updateItem(subSectionName: string, itemName: string, description: Array<string>, price: number) {
        if (!this.subSections[subSectionName][itemName]) {
            return this.addItem(subSectionName, itemName, description, price);
        }
        this.subSections[subSectionName].updateItem(itemName, description, price);
    }
}

export class Menu {
    private brunch: Section;
    private dinner: Section;
    private daily: Section;

    constructor(brunch: Section, dinner: Section, daily: Section) {
        this.brunch = brunch;
        this.dinner = dinner;
        this.daily = daily;
    }

    // GETTERS

    getBrunch() {
        return this.brunch;
    }
    getDinner() {
        return this.dinner;
    }
    getDaily() {
        return this.daily;
    }
    
    getAllBrunch() {
        return this.brunch.getAllSubSectionsAndItems();
    }
    getAllDinner() {
        return this.dinner.getAllSubSectionsAndItems();
    }
    getAllDaily() {
        return this.daily.getAllSubSectionsAndItems();
    }
    

    // SETTERS

    setBrunch(brunch: Section) {
        this.brunch = brunch;
    }
    setDinner(dinner: Section) {
        this.dinner = dinner;
    }
    setDaily(daily: Section) {
        this.daily = daily;
    }
}