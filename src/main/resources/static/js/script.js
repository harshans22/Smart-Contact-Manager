
let currentTheme=getTheme();
//initialize theme
changeTheme();

//TODO: 
function changeTheme() {
    //set to web page
    document.querySelector('html').classList.add(currentTheme);
    //set the listener to theme button
    const changeThemeButton=document.querySelector('#theme_change_button');
    changeThemeButton.addEventListener('click', function() {
        //remove the current theme
        document.querySelector('html').classList.remove(currentTheme);
        if(currentTheme=='light') {
            currentTheme='dark';
        }
        else {
            currentTheme='light';
        }
        //local stroage update
        setTheme(currentTheme);
        //set the current theme
        document.querySelector('html').classList.add(currentTheme);

  
        //change the text of button
        changeThemeButton.querySelector('span').textContent=currentTheme=='light'? 'Dark': 'Light';
    });
}


//set theme to local storage
function setTheme(theme) {
    localStorage.setItem('theme', theme);
}

//get theme from local storage
function getTheme() {
    let theme= localStorage.getItem('theme');
    return theme? theme: 'light';
}