<%@include file = "user.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#782b3d;">

    <div class="container-fluid">
        <a class="navbar-brand" href="/">UpperElectronics KZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <%
                    if(ONLINE){
                %>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">ITEM DETAIL</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/company">Brand</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/items/searchByCategory">Category</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/clientprofile"><%=currentClient.getfName()%></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/logout">Logout</a>
                    </li>

                <%
                    }else{
                %>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">Home</a>
                    </li>



                    <li class="nav-item">
                        <a class="nav-link active" href="/company">Brands</a>
                    </li>

                    <li class="nav-item" class="dropdown">
                        <a class="nav-link active" href="/items/searchByCategory">Category</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="#">TV</a></li>
                            <li><a class="dropdown-item" href="#">CellPhone</a></li>
                            <li><a class="dropdown-item" href="#">Tablet</a></li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/login">Login</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="/clientRegister">Register</a>
                    </li>

                <%
                    }
                %>

                <li class="nav-item">
                    <a class="nav-link active" href="/items/additem">Add Item</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>