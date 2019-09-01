<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Criar Memo</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <style>
        body{
            background-color: #fafafa;
            font-family: 'Roboto', sans-serif;
        }

        #footer_bottom{
            position: fixed;
            bottom: 0;
            height: 45px;
            width: 100%;
        }

        #text_buttons_formating{
            width: 100%;
            height: 45px;
        }

        @media screen and (max-width: 600px) {
            #footer_bottom {display: none; }
            #test {width: 100%; }
            #text_buttons_formating {position: fixed; bottom: 0; height: 40px; width: 365px; text-align: center;}
            body {overflow: hidden;}
        }  
    </style>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <script>
    $(document).ready(function(){
        $('.sidenav').sidenav();
    });
    </script>

    <nav style="height: 60px; width: 100%;" class="grey darken-1 dark-text">
        <div class="nav-wrapper">
            <a href="#" style="padding: 4px; color: whitesmoke;" class="brand-logo">Memorize</a>
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a style="color: whitesmoke;" href="#">Home</a></li>
                <li><a style="color: whitesmoke;" href="#">My Memos</a></li>
                <li><a style="color: whitesmoke;" href="#">About</a></li>
                <li><a style="color: whitesmoke;" href="#">Suport</a></li>
            </ul>
        </div>
    </nav>
    <ul class="sidenav" id="mobile-demo">
        <li><a href="#">Home</a></li>
        <li><a href="#">My Memos</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Suport</a></li>
    </ul>

    <main>
        <div class="container">
            <div class="col s12 center-align">
                <h2 style="color: #212121;">New Memo</h2>
            </div>         
            <div style="background-color: transparent;" class="center-align row">
            <form id="container"> 
                    <div class="center-align" id="text_buttons_formating">
                        <button class="btn grey lighten-3 black-text" id="bold" onclick="changeTextToBold()"><i class="material-icons">format_bold</i></button>
                        <button class="btn grey lighten-3 black-text" id="italic" onclick="changeTextToItalic()"><i class="material-icons">format_italic</i></button>
                        <button class="btn grey lighten-3 black-text" id="underline" onclick="changeTextToUnderline()"><i class="material-icons">format_underlined</i></button>
                        <button class="btn grey lighten-3 black-text" id="understrike" onclick="changeTextToUnderstrike()"><i class="material-icons">format_strikethrough</i></button>
                        <button class="btn grey lighten-3 black-text" id="list" onclick="changeTextToToDo()"><i class="material-icons">toc</i>
                        </button>
                        <button class="btn grey lighten-3 black-text" id="list" onclick="changeTextToList()"><i class="material-icons">list</i></button>
                    </div>
                    <div class="center-align row">
                        <textarea name="content" class="materialize-textarea" placeholder="Tap your note here"></textarea>
                        <button class="btn grey lighten-3 black-text">Save</button>
                    </div>
                </form>  
            </div>    
        </div>
    </main>
    <div id="footer_bottom" class="grey darken-1 dark-text"><h6 style="color: whitesmoke;" class="center-align">2019 - Memorize Team</h6></div>

    <script>
        function changeTextToBold(){
        }

        function changeTextToItalic(){
        }

        function changeTextToUnderline(){
        }

        function changeTextToUnderstrike(){
        }

        function changeTextToList(){
        }

        function changeTextToToDo(){
        }
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>