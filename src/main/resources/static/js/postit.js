$(function () {
  $("li").click(function () {
    $(this).toggleClass("done");
    console.log($(this));
  });
});
