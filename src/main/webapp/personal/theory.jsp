<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/foundation.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title></title>
</head>

<body>

<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li class="menu-text"><a href="#" class="logo">HogwartS.Online</a></li>
        </ul>

    </div>
    <div class="top-bar-right ">
        <ul class="dropdown middle align-middle menu" data-dropdown-menu>
            <li class="menu-text" style="color: white;"><a href="#">cuteAndrei24</a></li>
            <li class="menu-text"><a href="#" class="button">Start test</a></li>
            <li class="menu-text"><a href="#" class="button">Log out</a></li>
            <li class="menu-text"><a href="?lang=en"><img class="img-flag" src="img/4x3/gb.svg"></a></li>
            <li class="menu-text"><a href="?lang=ru"><img class="img-flag" src="img/4x3/ru.svg"></a></li>
            <li class="menu-text"><a href="?lang=by"><img class="img-flag" src="img/4x3/by.svg"></a></li>
        </ul>
    </div>
</div>



<div class="grid-container" style="padding: 30px 0;">
    <form method="POST">
        <div class="grid-x align-center text-center">
            <div>


                <div class="cell small-12 introduction">
                    Course name <button class="button newquestion hollow secondary" type="button"
                                        onclick="hideElement('nav')" id="hideIntro">Show navigation</button>
                    <hr>
                </div>
                <ol id="nav" class="hidden">
                    <li><a class="nav " href="#theory1">Theory block 1</a></li>
                    <li><a class="nav " href="#theory2">Theory block 2</a></li>
                    <li><a class="nav " href="#theory3">Theory block 3</a></li>
                </ol>

                <div class="cell small-12 introduction">
                    Introduction: <button class="button newquestion hollow secondary" type="button"
                                          onclick="hideElement('intro')" id="hideIntro">Hide</button>
                </div>
                <div id="intro" class="cell small-12" style="font-family: 'SofiaProLight'; font-size: 14pt;">Lorem,
                    ipsum dolor sit amet consectetur adipisicing elit.
                    Corrupti
                    placeat quaerat dignissimos at aspernatur voluptatem magni molestias consequuntur atque quo,
                    dolor unde, quos et quae sit. Architecto explicabo quis quia! Lorem, ipsum dolor sit amet
                    consectetur adipisicing elit. Veritatis sunt, fugit illum magnam quia officia consequuntur.
                    Magni dicta iure nesciunt nulla veniam quas laudantium, ullam, cumque doloremque aut, nisi odio.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa facere nemo, magnam, possimus
                    corrupti officiis perspiciatis mollitia velit eos similique recusandae dolor maxime ratione
                    praesentium rerum facilis, ex omnis alias. Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                </div>
                <div class="cell small-12 introduction" style="padding: 20px;">
                    Theory block 1:
                    <button class="button newquestion hollow secondary" type="button"
                            onclick="hideElement('theory1')">Hide</button>
                </div>
                <div id="theory1" class="cell small-12" style="font-family: 'SofiaProLight'; font-size: 14pt;">
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                </div>
                <div class="cell small-12 introduction" style="padding: 20px;">
                    Theory block 2:
                    <button class="button newquestion hollow secondary" type="button"
                            onclick="hideElement('theory2')">Hide</button>
                </div>
                <div id="theory2" class="cell small-12" style="font-family: 'SofiaProLight'; font-size: 14pt;">
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                </div>
                <div class="cell small-12 introduction" style="padding: 20px;">
                    Theory block 3:
                    <button class="button newquestion hollow secondary" type="button"
                            onclick="hideElement('theory3')">Hide</button>
                </div>
                <div id="theory3" class="cell small-12" style="font-family: 'SofiaProLight'; font-size: 14pt;">
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                    Lorem ipsum dolor sit amet, consectetur adipisicing
                    elit. Quibusdam, animi voluptatem tenetur consequuntur accusamus aut, optio quis sint
                    dignissimos quidem recusandae illo hic libero deleniti. Ad et vitae veniam voluptatum.
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nobis dolore deleniti odit corrupti,
                    optio sint. Iste, ipsa adipisci voluptatem rerum deleniti exercitationem quisquam explicabo
                    alias tenetur, incidunt ipsum vitae. Minus. Lorem ipsum dolor sit amet consectetur adipisicing
                    elit. Sapiente, accusantium iste! Autem doloremque ea tempore, ex illum nesciunt fugit veritatis
                    quis nostrum sit ut quia officiis aut eveniet error soluta. Lorem ipsum dolor sit amet
                    consectetur adipisicing elit. Unde explicabo aperiam in ad culpa, fugiat rerum possimus ex at
                    perspiciatis modi, ducimus alias ut itaque architecto, doloremque voluptatum blanditiis debitis.
                </div>
            </div>
        </div>
    </form>
</div>


<footer>

    <div style="background-color: white; width: 100%; max-width: 100%;" class="grid-container">
        <hr>
        <div class="grid-x grid-margin-x">
            <div class="cell text-center copyright">@2021 Artuhanau&Co.</div>
        </div>
        <hr style="width: 250%;">
        <div class="grid-x align-center text-center grid-margin-x">
            <div class="cell small-4 telegram">Telegram <a href="#"><img src="img/telegram_icon.svg"
                                                                         width="25px"></a> </div>
            <div class="cell small-4 rights ">All rights reserved.</div>
            <div class="cell small-4">Have a question? You can phone +375 29 784 1845.</div>
        </div>
    </div>
</footer>
</body>
<script>
    var navTrigger = document.getElementsByClassName('nav-trigger')[0],
        body = document.getElementsByTagName('body')[0];

    navTrigger.addEventListener('click', toggleNavigation);

    function toggleNavigation(event) {
        event.preventDefault();
        body.classList.toggle('nav-open');
    }
    function hideElement(name) {
        let introClassList = document.getElementById(name).classList;
        if (introClassList.contains("hidden")) {
            introClassList.remove("hidden")
        } else {
            introClassList.add("hidden")
        }
    }
</script>

</html>