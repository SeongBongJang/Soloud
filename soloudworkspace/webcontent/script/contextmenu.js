$(function() {
    $('.list_table').contextPopup({
      title: '관리자 메뉴',
      items: [
        {label:'Some Item',     icon:'/Soloud/image/icons/shopping-basket.png',             action:function() { alert('clicked 1'); } },
        {label:'Another Thing', icon:'/Soloud/image/icons/receipt-text.png',                action:function() { alert('clicked 2'); } },
        {label:'Blah Blah',     icon:'/Soloud/image/icons/book-open-list.png',              action:function() { alert('clicked 3'); } },
        null, // divider
        {label:'Sheep',         icon:'/Soloud/image/icons/application-monitor.png',         action:function() { alert('clicked 4'); } },
        {label:'Cheese',        icon:'/Soloud/image/icons/bin-metal.png',                   action:function() { alert('clicked 5'); } },
        {label:'Bacon',         icon:'/Soloud/image/icons/magnifier-zoom-actual-equal.png', action:function() { alert('clicked 6'); } },
        null, // divider
        {label:'Onwards',       icon:'/Soloud/image/icons/application-table.png',           action:function() { alert('clicked 7'); } },
        {label:'Flutters',      icon:'/Soloud/image/icons/cassette.png',                    action:function() { alert('clicked 8'); } }
      ]
    });
  });