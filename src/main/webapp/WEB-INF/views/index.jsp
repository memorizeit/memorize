<!DOCTYPE html>
<html>
<head>
<title>Novo Memo</title>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<link rel="stylesheet"
	href="/resources/vendor/sceditor-2.1.3/minified/themes/memorize.min.css"
	id="theme-style" />
<script src="/resources/vendor/sceditor-2.1.3/minified/sceditor.min.js"></script>
<script
	src="/resources/vendor/sceditor-2.1.3/minified/icons/monocons.js"></script>
<script
	src="/resources/vendor/sceditor-2.1.3/minified/formats/bbcode.js"></script>
</head>
<body>

	<textarea id="example" style="height:300px;width:600px;"></textarea>
	<script>
		var textarea = document.getElementById('example');
		sceditor.create(textarea, {
			format : 'bbcode',
			icons : 'monocons',
			emoticonsRoot: '/resources/vendor/sceditor-2.1.3/',
			style : '/resources/vendor/sceditor-2.1.3/minified/themes/content/memorize.min.css'
		});
	</script>
</body>
</html>