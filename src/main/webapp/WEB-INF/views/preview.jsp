<!DOCTYPE html>
<html>
<head>
<title>Novo Memo</title>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<link rel="stylesheet"
	href="/resources/vendor/sceditor-2.1.3/minified/themes/memorize.min.css"
	id="theme-style" />
<script
	src="/resources/vendor/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="/resources/vendor/sceditor-2.1.3/minified/sceditor.min.js"></script>
<script
	src="/resources/vendor/sceditor-2.1.3/minified/icons/monocons.js"></script>
<script
	src="/resources/vendor/sceditor-2.1.3/minified/formats/bbcode.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link type="text/css" rel="stylesheet"
	href="/resources/vendor/materialize-v1.0.0/css/materialize.min.css"
	media="screen,projection" />

<link type="text/css" rel="stylesheet"
	href="/resources/memorize/css/style.css" media="screen,projection" />
</head>
<body>
	<nav>
		<div class="nav-wrapper light-blue darken-2">
			<a href="#" class="brand-logo">Memorize</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="#">New</a></li>
				<li><a href="#">Memos</a></li>
				<li><a href="#">Profile</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="row">
		<div class="col s12 m12">
			<input type="hidden" id="memo-id" value="">
			<input id="bbcode-title" type="text" placeholder="Title of this Memo"
				title="Title of this Memo" readonly>
			<textarea id="bbcode-area" style="height: 300px"></textarea>
		</div>
	</div>

	<script>
		var bbcodeArea = document.getElementById('bbcode-area');
		sceditor
				.create(
						bbcodeArea,
						{
							format : 'bbcode',
							icons : 'monocons',
							emoticonsRoot : '/resources/vendor/sceditor-2.1.3/',
							style : '/resources/vendor/sceditor-2.1.3/minified/themes/content/memorize.min.css',
							toolbar : '',
							locale : 'pt-BR',
							width : '100%',
							resizeEnabled: false,
							readOnly: true
						});
	</script>
	<script type="text/javascript"
		src="/resources/vendor/materialize-v1.0.0/js/materialize.min.js"></script>
	<script src="/resources/memorize/js/script.js"></script>
	<script>loadMemo()</script>
</body>
</html>