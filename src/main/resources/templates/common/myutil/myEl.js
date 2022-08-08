'use strict'

var myEl = (function () {

    //设置消息弹出
    function elAlert(status, msg) {
        let title;
        let type;
        if (status == 200) {
            title = '成功';
            type = 'success';
        } else {
            title = '失败';
            type = 'error';
        }
        const h = vm.$createElement;
        vm.$message({
            showClose: true,
            message: msg,
            type: type,
            duration: 1500,
            center: true,
            offset: 30
        });
        // vm.$notify({
        //     title: title,
        //     message: h('i', { style: 'color: teal'}, msg),
        //     type: type,
        //     offset: 30,
        //     duration: 1500,
        //     showClose: true
        // });
    }


    return {
        elAlert: elAlert
    }
})();