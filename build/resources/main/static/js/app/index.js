var main = {
//js파일 별로 유효범위를 만들기위해 해당 객체에서 필요한 모든 function을 선언.
    init : function () {
        var _this = this;
        $('#btn-save').on('click',function(){
            _this.save();
        });

        $('#btn-update').on('click', function(){
            _this.update();
        });

        $('#btn-delete').on('click', function(){
            _this.delete();
        });

        //test
        $('#btn-custom').on('click', function(){
            _this.custom();
        });
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type:'POST',
            url:'/api/v1/posts',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    update:function(){
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type:'PUT',
            url:'/api/v1/posts/' + id,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(data)
         }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href='/';
         }).fail(function(error){
            alert(JSON.stringify(error));
         })
    },
    delete:function(){
        var id=$('#id').val();

        $.ajax({
            type:'DELETE',
            url:'/api/v1/posts/' + id,
            dataType:'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(){
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    custom:function(){
        var id=$('#id').val();

        var result = "";
        $.ajax({
            type:'PUT',
            url:'/api/v1/' + id,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
        }).done(function(result){
            alert('제목이 변경됨.' + result);
        //    window.location.href = '/';
             window.location.href='/posts/update/' + id;
        }).fail(function (error){
            alert(JSON.stringify(error));
        });

    }
};

main.init();