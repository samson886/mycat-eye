$(document).ready( function() {

	/*--------------------------------/
	/* NAVIGATION
	/*-------------------------------*/

	$(window).bind('load resize', function() {
		checkNavByScreenSize();
	});

	function checkNavByScreenSize() {
		// mobile main navigation
		if( $(window).width() < 993 ) {

			// reset padding-top since navbar-fixed-top is disabled
			$('body').css('padding-top', 0);

			// dropdown menu in navbar-fixed-top can't be scrolled
			if($('.navbar-default').hasClass('navbar-fixed-top') && $('.navbar-default .nav-onepage').length <= 0) {
				$('.navbar-default').removeClass('navbar-fixed-top');
			}

			// re-enable dropdown cart toggle
			$('.dropdown-cart .dropdown-toggle').removeClass('disabled');
			$('ul.main-navbar-nav > li > .dropdown-toggle').removeClass('disabled');
		} else {

			// body padding-top adjustment for page with navbar-fixed-top
			if($('.navbar').hasClass('navbar-fixed-top') && !$('.navbar').hasClass('ignore-paddingtop')) {
				$('body').css('padding-top', $('.navbar-fixed-top').innerHeight());
			}

			// re-enable navbar-fixed-top
			if($('.navbar-default').hasClass('ignore-paddingtop')) { // ignore-paddingtop class indicating that it's or it should a fixed-top nav
				$('.navbar-default').addClass('navbar-fixed-top');
			}

			// disable toggle
			$('ul.main-navbar-nav > li > .dropdown-toggle').addClass('disabled');
		}
	}

	// submenu dropdown click event
	$('ul.dropdown-menu [data-toggle=dropdown]').on('click', function(e) {
		e.preventDefault(); 
		e.stopPropagation(); 
		$(this).parent().siblings().removeClass('open');
		$(this).parent().toggleClass('open');
	});

	// full transparent fixed-top navbar should have background when scrolled
	if($('.navbar-fixed-top.navbar-no-background').length > 0) {
		$(window).scroll(function() {
			if($(document).scrollTop() > 100) {
				$('.navbar-fixed-top').removeClass('navbar-no-background');
			}else {
				$('.navbar-fixed-top').addClass('navbar-no-background');
			}
		});
	}


	/*----------------------------/
	/* TESTIMONIALS
	/*---------------------------*/

	if( $('#testimonial-standard-carousel').length > 0 ) {
		$('#testimonial-standard-carousel').owlCarousel({
			singleItem: true,
			autoPlay: 3000,
			transitionStyle: 'fade'
		});
	}


	/*----------------------------/
	/* ROTATING WORDS
	/*---------------------------*/

	if( $("#rotating-words").length > 0) {
		$("#rotating-words").Morphext({
			animation: "fadeInUp",
			separator: ",",
			speed: 3000
		});
	}


	/*----------------------------/
	/* FIT VIDEO
	/*---------------------------*/

	if($('.fit-video').length > 0) {
		$('.fit-video').fitVids();
	}


	/*-----------------------------------/
	/* TWITTER FETCHER
	/*----------------------------------*/

	if( $('#tweets').length > 0 ) {
		function momentDateFormatter(date, dateString) {
			return moment(dateString).fromNow();
		}

		function populateTpl(tweets){
			var element = document.getElementById('tweets');
			var html = '<ul class="list-inline">';
			for (var i = 0, lgth = tweets.length; i < lgth ; i++) {
				var tweetObject = tweets[i];

				html += '<li>'
				+ '<div class="tweet-infos">' + tweetObject.author + '</div>'
				+ '<p class="tweet-content">' + tweetObject.tweet + '</p>'
				+ '<span class="tweet-time">' + tweetObject.time  + '</span>'
				+ '</li>';
			}

			html += '</ul>';
			element.innerHTML = html;
		}

		twitterFetcher.fetch({
			"id": '441767385733668865',
			"maxTweets": 5,
			"enableLinks": true,
			"dateFunction": momentDateFormatter,
			"dataOnly": true,
			"customCallback": populateTpl
		});
	}

});




