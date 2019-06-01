var main = {
    init : function(){
        var _this = this;
        $('#save').on('click', function(){
            _this.save();
        });
        $('.delete').on('click', function(){
            _this._delete();
        });
        $('.edit').on('click', function(){
            _this.edit();
        });
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
    _delete : function (id) {
        var data = {
            _id : id
        };

        $.ajax({
            type: 'GET',
            url: '/delete/'+Number(_id),
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },
    edit : function (id) {
        var data = {
            _id : id,
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/update/'+Number(_id),
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다..');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
};

main.init();