<#include "header.ftlh">

        <div class="row">
            <div class="col-12" id="main">

                <#assign visible = true>

                <#if searchResultSize??>
                    <#assign visible = false>
                    <div class="row">
                        <p class="font-weight-light" id="search_result_info"><a id="search_close_button" href="list"><i class="fas fa-times-circle"></i></a>${search_info_part_1} <b>${searchPhrase}</b> ${search_info_part_2} <b>${searchResultSize}</b></p>
                    </div>
                </#if>

                <#assign nullLetter = "">
                <#list contactList?sort_by("surname") as contact>

                <form method="post" action="details">

                    <#if nullLetter != contact.surname?substring(0, 1)>
                        <p><b>${contact.surname?substring(0, 1)}</b></p>
                    </#if>

                    <#assign nullLetter = contact.surname?substring(0, 1)>
                        <input type="hidden" name="id" value="${contact.id}"/>
                        <button class="btn" type="submit">${contact.name} <b>${contact.surname}</b></button>


                    <#if contact_has_next>
                        <hr class="my-4">
                    </#if>

                </form>

                <#else>
                    <#if visible>
                        <ul class="nav flex-column" id="empty_list">
                            <li class="nav-item">
                                <p class="font-weight-light">${list_empty}</p>
                                <a class="nav-link font-weight-light" href="handler?action=demo">DEMO</a>
                            </li>
                        </ul>
                    </#if>
                </#list>

            </div>
        </div>

<#include "footer.ftlh">