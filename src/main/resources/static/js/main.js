var editOn = false;
var main = {
    init : function(){
        var _this = this;
        $('#save').on('click', function(){
            _this.save();
        });
        $('#update2').on('click', function(){
            _this.edit();
        });
        $('.delete').on('click', function(){
            _this._delete();
        });

        $('#modal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) ;// Button that triggered the modal
            var recipient = button.data('whatever'); // Extract info from data-* attributes
            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
            var modal = $(this);
            modal.find('.modal-title').text("글 수정하기");
            modal.find("#title2").attr('value', $("#t").text());
            modal.find("#content2").text($("#c").text());
        })
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/create',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },
    edit : function () {
        var _id =  $("#update").attr("name");
        var data = {
            title: $('#title2').val(),
            content: $('#content2').val()
        };

        $.ajax({
            type: 'POST',
            url: '/update/'+_id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다..');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },
    _delete : function () {
        var _id =  $("#delete").attr("name");
        $.ajax({
            type: 'GET',
            url: '/delete/'+_id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },
};

main.init();