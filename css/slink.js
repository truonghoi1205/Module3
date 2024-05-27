
$('.product-slider').slick({
    centerMode: true,
    centerPadding: '14px',
    slidesToShow: 4,
    prevArrow: '<button type="button" class="slick-prev abc-right"><i class="fa-solid fa-chevron-left"></i></button>',
    nextArrow: '<button type="button" class="slick-next abc-left"><i class="fa-solid fa-chevron-right"></i></button>',
    responsive: [
      {
        breakpoint: 700,
        settings: {
          arrows: false,
          centerMode: true,
          centerPadding: '40px',
          slidesToShow: 8
        }
      },
      {
        breakpoint: 700,
        settings: {
          arrows: false,
          centerMode: true,
          centerPadding: '40px',
          slidesToShow: 1
        }
      }
    ]
  });