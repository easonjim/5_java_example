<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div>
            <form action="UploadServlet" method="POST" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td><label for="file1">文件1：</label></td>
                        <td><input type="file" id="file1" name="file1"></td>
                    </tr>
                    <tr>
                        <td><label for="file2">文件2：</label></td>
                        <td><input type="file" id="file2" name="file2"></td>
                    </tr>
                    <tr>
                        <td><label for="file3">文件3：</label></td>
                        <td><input type="file" id="file3" name="file3"></td>
                    </tr>
                    <tr>
                        <td><label for="file3">Text：</label></td>
                        <td><input type="text" id="text1" name="text1"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="上传" name="upload"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>