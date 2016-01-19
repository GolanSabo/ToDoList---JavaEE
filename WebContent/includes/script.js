$(document).ready(function() {
    $('[id^=detail-]').hide();
    $('.toggle').click(function() {
        $input = $( this );
        $target = $('#'+$input.attr('data-toggle'));
        $target.slideToggle();
    });
    
    var next = 1;
    $(".add-more").click(function(e){
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        next = next + 1;
        var newIn = '<input autocomplete="off" class="input form-control" id="field' + next + '" name="field' + next + '" type="text">';
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-danger remove-me" >-</button></div><div id="field">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#field" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);  
        
            $('.remove-me').click(function(e){
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length-1);
                var fieldID = "#field" + fieldNum;
                $(this).remove();
                $(fieldID).remove();
            });
    });
    
    var myNavBar = {

    	    flagAdd: true,

    	    elements: [],

    	    init: function (elements) {
    	        this.elements = elements;
    	    },

    	    add : function() {
    	        if(this.flagAdd) {
    	            for(var i=0; i < this.elements.length; i++) {
    	                document.getElementById(this.elements[i]).className += " fixed-theme";
    	            }
    	            this.flagAdd = false;
    	        }
    	    },

    	    remove: function() {
    	        for(var i=0; i < this.elements.length; i++) {
    	            document.getElementById(this.elements[i]).className =
    	                    document.getElementById(this.elements[i]).className.replace( /(?:^|\s)fixed-theme(?!\S)/g , '' );
    	        }
    	        this.flagAdd = true;
    	    }

    
    }});


