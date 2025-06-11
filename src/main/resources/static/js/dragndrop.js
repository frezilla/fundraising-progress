const dragOverHandler = (ev) => {
    ev.preventDefault();
};

const dragStartHandler = (ev) => {
    ev.dataTransfer.setData("text", ev.target.id);
};

const dropHandler = (ev) => {
    ev.preventDefault();
    const data = ev.dataTransfer.getData("text");
    ev.target.appendChild(document.getElementById(data));
};


