<#import "../parts/common.ftl" as c>
<#import "../parts/token.ftl" as t>

<@c.page>
Покупка билета на представление "${performance.name}"
<p>
<div>
    Общее число свободных мест: ${performance.seats}
</div>
<div>
    <form action="/buy" method="post">
        Свободные места на балконе: ${performance.seats_on_balcony!}
        <input type="hidden" value="${performance.balcony}" name="place">
        <input type="hidden" value="${performance.id}" name="performanceId">
        <@t.token/>
        <button type="submit">Купить за ${performance.price_balcony} руб.</button>
    </form>
</div>
<div>
    <form action="/buy" method="post" name="dressCircle">
        Свободные места на бельэтаже: ${performance.seats_on_dress_circle!}
        <input type="hidden" value="${performance.dress_circle}" name="place">
        <input type="hidden" value="${performance.id}" name="performanceId">
        <@t.token/>
        <button type="submit">Купить за ${performance.price_dress_circle} руб.</button>
    </form>
</div>
<div>
    <form action="/buy" method="post" name="parter">
        Свободные места в партере: ${performance.seats_on_parter!}
        <input type="hidden" value="${performance.parter}" name="place">
        <input type="hidden" value="${performance.id}" name="performanceId">
        <@t.token/>
        <button type="submit">Купить за ${performance.price_parter} руб.</button>
    </form>
</div>
<p>
</@c.page>