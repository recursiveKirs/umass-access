const observableModule = require("data/observable");

function HomeViewModel(info) {
    info = info || {};

    var viewModel = new observableModule.fromObject({
        latitude: "",
        longitude: "",
        zoom: "",
        bearing: "",
        tilt: "",
        padding: [0,0,0,0]
    })
  

    return viewModel;
}

module.exports = HomeViewModel;
